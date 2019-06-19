package io.dy.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.dy.api.BitcoinJsonRpcApi;
import io.dy.api.BitcoinRestApi;
import io.dy.dao.BlockMapper;
import io.dy.dao.TransactionMapper;
import io.dy.dao.Transaction_detailMapper;
import io.dy.enumeration.Transaction_detailType;
import io.dy.po.Block;
import io.dy.po.Transaction;
import io.dy.po.Transaction_detail;
import io.dy.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;

@Service
public class BitcoinServiceImpl implements BitcoinService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @Override
    @Async //异步
    public void syncBlockchainByHash(String blockhash) throws Throwable {
        logger.info("begin to sync blockchain from => {}", blockhash);

        //通过临时的块的哈希值 记录当前的hash
        String tempBlockhash = blockhash;
        //循环导入数据库
        while (tempBlockhash != null && !tempBlockhash.isEmpty()){

            String nextBlock = syncBlock(tempBlockhash);
            tempBlockhash = nextBlock;
        }
        logger.info("end sync blockchain");
    }

    @Override
    @Transactional
    public String syncBlock(String blockhash) throws Throwable{
            JSONObject blockByblockhash = bitcoinRestApi.getBlockByblockhash(blockhash);
            Block block = new Block();
            block.setBlockhash(blockByblockhash.getString("hash"));
            block.setConfirmations(blockByblockhash.getInteger("confirmations"));
            block.setStrippedsize(blockByblockhash.getInteger("strippedsize"));
            block.setSize(blockByblockhash.getInteger("size"));
            block.setWeight(blockByblockhash.getInteger("weight"));
            block.setHeight(blockByblockhash.getInteger("height"));
            block.setVersion(blockByblockhash.getInteger("version"));
            block.setMerkleroot(blockByblockhash.getString("merkleroot"));
            Long timestamp = blockByblockhash.getLong("time");
            Date time = new Date(timestamp * 1000);
            block.setTime(time);
            block.setNonce(blockByblockhash.getInteger("nonce"));
            block.setDifficulty(blockByblockhash.getInteger("difficulty"));
            block.setChainwork(blockByblockhash.getString("chainwork"));
            block.setTxsize(blockByblockhash.getInteger("nTx"));
            block.setPrevBlock(blockByblockhash.getString("previousblockhash"));
            block.setNextBlock(blockByblockhash.getString("nextblockhash"));
            Integer confirmations = blockByblockhash.getInteger("confirmations");
            blockMapper.insert(block);

            JSONArray txArray = blockByblockhash.getJSONArray("tx");
            for (Object txObj : txArray) {
                //tx 中的每一笔交易都是 一个 LinkedHashMap
                JSONObject jsonObject = new JSONObject((LinkedHashMap) txObj);
                //同步块中的交易
                syncTransaction(jsonObject,blockhash,time,confirmations);
            }

             return block.getNextBlock();
    }

    @Override
    @Transactional
    public void syncTransaction(JSONObject transactionJson, String blockhash, Date time, Integer confirmations) throws Throwable{
        Transaction ts = new Transaction();
        String txid = transactionJson.getString("txid");
        ts.setTxhash(txid);
        //todo
        ts.setAmount(null);
        ts.setTime(time);
        ts.setSize(transactionJson.getInteger("size"));
        ts.setWeight(transactionJson.getFloat("weight"));
        ts.setBlockhash(blockhash);
        ts.setConfirmations(confirmations);
        transactionMapper.insert(ts);
        //同步交易详情信息
        syncTransaction_detail(transactionJson,txid);
    }

    @Override
    @Transactional
    public void syncTransaction_detail(JSONObject transactionJson, String txid) throws Throwable{
        JSONArray vout = transactionJson.getJSONArray("vout");
        syncTransaction_detailVout(vout,txid);
        JSONArray vins = transactionJson.getJSONArray("vin");
        syncTransaction_detailVin(vins,txid);
    }

    //输出记一笔交易
    @Override
    @Transactional
    public void syncTransaction_detailVout(JSONArray vouts, String txid) throws Throwable{
        for (Object voutObj : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) voutObj);
            Transaction_detail transaction_detail = new Transaction_detail();
            transaction_detail.setAmount(jsonObject.getDouble("value"));
            transaction_detail.setTxhash(txid);
            transaction_detail.setType((byte) Transaction_detailType.Receive.ordinal());
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray addresses = scriptPubKey.getJSONArray("addresses");
            //过滤到 区块的第一条交易 第一条交易一般是区块奖励区块
            if(addresses!=null){
                String address = addresses.getString(0);
                transaction_detail.setAddress(address);
            }
            transaction_detailMapper.insert(transaction_detail);
        }
    }

    //输入记录一笔交易
    @Override
    @Transactional
    public void syncTransaction_detailVin(JSONArray vins , String txid) throws Throwable{
        for (Object vinObj : vins) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vinObj);
            String vinTransactionid = jsonObject.getString("txid");
            Integer n = jsonObject.getInteger("vout");

            if(vinTransactionid!=null){
                JSONObject vinTransactionJson = bitcoinJsonRpcApi.getTransactionById(vinTransactionid);
                JSONArray vouts = vinTransactionJson.getJSONArray("vout");
                JSONObject utxoJson = vouts.getJSONObject(n);

                Transaction_detail transaction_detail = new Transaction_detail();
                transaction_detail.setAmount(-utxoJson.getDouble("value"));
                transaction_detail.setTxhash(txid);
                transaction_detail.setType((byte) Transaction_detailType.Send.ordinal());
                JSONObject scriptPubKey = utxoJson.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if (addresses != null){
                    String address = addresses.getString(0);
                    transaction_detail.setAddress(address);
                }
                transaction_detailMapper.insert(transaction_detail);
            }

        }
    }

}
