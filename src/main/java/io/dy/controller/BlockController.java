package io.dy.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.dy.api.BitcoinJsonRpcApi;
import io.dy.api.BitcoinRestApi;
import io.dy.dto.BlockGetDTO;
import io.dy.dto.BlockListDTO;
import io.dy.po.Block;
import io.dy.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*")
public class BlockController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @Autowired
    private BlockService blockService;

    //通过RestApi去查
    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks() throws Throwable {


        List<BlockListDTO> blockListDTOS = new ArrayList<>();
        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        Integer blockHeight = blockChainInfo.getInteger("blocks");
        Integer blockFromHeight = blockHeight - 5;

        String blockhash = bitcoinJsonRpcApi.getBlockhashByHeight(blockFromHeight);

        List<JSONObject> blockheaders = bitcoinRestApi.getBlockheaders(5, blockhash);

        for (Object blockheader : blockheaders) {
            JSONObject jsonObject = (JSONObject) blockheader;
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(jsonObject.getString("hash"));
            blockListDTO.setHeight(jsonObject.getInteger("height"));
            Long time = jsonObject.getLong("time");
            blockListDTO.setTime(new Date(1000*time));
            blockListDTO.setTxsize(jsonObject.getInteger("nTx"));
            blockListDTO.setChainwork(jsonObject.getString("chainwork"));
            //todo
            blockListDTO.setSize(null);
            blockListDTOS.add(blockListDTO);
        }
        return blockListDTOS;
    }

    @GetMapping("/getlatelyBlocks")
    public List<BlockListDTO> getlatelyBlocks(){
        List<BlockListDTO> recentBlocks = blockService.getRecentBlocks();
        return recentBlocks;
    }



    @GetMapping("/getByBlockhash/{blockhash}")
    public BlockGetDTO getByBlockhash(@PathVariable String blockhash) throws Throwable {

        JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash(blockhash);
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash(blockByHash.getString("hash"));
        blockGetDTO.setConfirmations(blockByHash.getInteger("confirmations"));
        blockGetDTO.setSize(blockByHash.getInteger("size"));
        blockGetDTO.setTxsize(blockByHash.getInteger("nTx"));
        blockGetDTO.setWeight(blockByHash.getInteger("weight"));
        blockGetDTO.setHeight(blockByHash.getInteger("height"));
        blockGetDTO.setVersion(blockByHash.getInteger("version"));
        blockGetDTO.setMerkleroot(blockByHash.getString("merkleroot"));
        Long time = blockByHash.getLong("time");
        blockGetDTO.setTime(new Date(1000*time));
        blockGetDTO.setReceivedTime(new Date(1000*time));
        blockGetDTO.setNonce(blockByHash.getInteger("nonce"));
        blockGetDTO.setDifficulty(blockByHash.getInteger("difficulty"));
        blockGetDTO.setChainwork(blockByHash.getString("chainwork"));
        blockGetDTO.setPrevBlock(blockByHash.getString("previousblockhash"));
        blockGetDTO.setNextBlock(blockByHash.getString("nextblockhash"));
        //todo
        blockGetDTO.setOutputTotal(null);
        blockGetDTO.setFees(null);
        blockGetDTO.setBlockReward(null);
        blockGetDTO.setRelayedBy(null);

        JSONArray tx = blockByHash.getJSONArray("tx");
        List<String> list = new ArrayList<>();
        for (Object o : tx) {
            list.add((String) o);
        }
        blockGetDTO.setTransactionList(list);



//        blockGetDTO.setBlockhash("0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330");
//        blockGetDTO.setConfirmations(1);
//        blockGetDTO.setStrippedsize(18186);
//        blockGetDTO.setSize(36317);
//        blockGetDTO.setTxsize(111);
//        blockGetDTO.setWeight(90875);
//        blockGetDTO.setHeight(1543652);
//        blockGetDTO.setVersion(536928256);
//        blockGetDTO.setMerkleroot("e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5");
//        blockGetDTO.setTime(new Date());
//        blockGetDTO.setReceivedTime(new Date());
//        blockGetDTO.setNonce(214911287);
//        blockGetDTO.setDifficulty(4194304);
//        blockGetDTO.setChainwork("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
//        blockGetDTO.setPrevBlock("00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184");
//        blockGetDTO.setNextBlock("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
//        blockGetDTO.setOutputTotal(4465.02389308);
//        blockGetDTO.setFees(0.63557721);
//        blockGetDTO.setBlockReward(12.5);
//        blockGetDTO.setRelayedBy("AntPool");
//        List<String> list = new ArrayList<>();
//        list.add("4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb");
//        list.add("4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3");
//        list.add("9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4");
//        list.add("8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf");
//        list.add("9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82");
//        list.add("9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889");
//        list.add("563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01");
//        list.add("6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408");
//        blockGetDTO.setTransactionList(list);
        return blockGetDTO;
    }

    @GetMapping("/getByHeight/{height}")
    public BlockGetDTO getByHeight(@PathVariable Integer height) throws Throwable {

        String blockhash = bitcoinJsonRpcApi.getBlockhashByHeight(height);
        if(blockhash!=null) {
            JSONObject blockByHash = bitcoinJsonRpcApi.getBlockByHash(blockhash);

            BlockGetDTO blockGetDTO = new BlockGetDTO();
            blockGetDTO.setBlockhash(blockByHash.getString("hash"));
            blockGetDTO.setConfirmations(blockByHash.getInteger("confirmations"));
            blockGetDTO.setSize(blockByHash.getInteger("size"));
            blockGetDTO.setTxsize(blockByHash.getInteger("nTx"));
            blockGetDTO.setWeight(blockByHash.getInteger("weight"));
            blockGetDTO.setHeight(blockByHash.getInteger("height"));
            blockGetDTO.setVersion(blockByHash.getInteger("version"));
            blockGetDTO.setMerkleroot(blockByHash.getString("merkleroot"));
            Long time = blockByHash.getLong("time");
            blockGetDTO.setTime(new Date(1000 * time));
            blockGetDTO.setReceivedTime(new Date(1000 * time));
            blockGetDTO.setNonce(blockByHash.getInteger("nonce"));
            blockGetDTO.setDifficulty(blockByHash.getInteger("difficulty"));
            blockGetDTO.setChainwork(blockByHash.getString("chainwork"));
            blockGetDTO.setPrevBlock(blockByHash.getString("previousblockhash"));
            blockGetDTO.setNextBlock(blockByHash.getString("nextblockhash"));
            //todo
            blockGetDTO.setOutputTotal(null);
            blockGetDTO.setFees(null);
            blockGetDTO.setBlockReward(null);
            blockGetDTO.setRelayedBy(null);

            JSONArray tx = blockByHash.getJSONArray("tx");
            List<String> list = new ArrayList<>();
            for (Object o : tx) {
                list.add((String) o);
            }
            blockGetDTO.setTransactionList(list);
            return blockGetDTO;
        }else{
            return null;
        }


 //        blockGetDTO.setBlockhash("0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330");
//        blockGetDTO.setConfirmations(1);
//        blockGetDTO.setStrippedsize(18186);
//        blockGetDTO.setSize(36317);
//        blockGetDTO.setTxsize(111);
//        blockGetDTO.setWeight(90875);
//        blockGetDTO.setHeight(1543652);
//        blockGetDTO.setVersion(536928256);
//        blockGetDTO.setMerkleroot("e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5");
//        blockGetDTO.setTime(new Date());
//        blockGetDTO.setReceivedTime(new Date());
//        blockGetDTO.setNonce(214911287);
//        blockGetDTO.setDifficulty(4194304);
//        blockGetDTO.setChainwork("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
//        blockGetDTO.setPrevBlock("00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184");
//        blockGetDTO.setNextBlock("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
//        blockGetDTO.setOutputTotal(4465.02389308);
//        blockGetDTO.setFees(0.63557721);
//        blockGetDTO.setBlockReward(12.5);
//        blockGetDTO.setRelayedBy("AntPool");
//        List<String> list = new ArrayList<>();
//        list.add("4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb");
//        list.add("4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3");
//        list.add("9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4");
//        list.add("8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf");
//        list.add("9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82");
//        list.add("9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889");
//        list.add("563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01");
//        list.add("6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408");
//        blockGetDTO.setTransactionList(list);

    }

    @GetMapping("/blockview/{nowdate}/{day}")
    public List<Block> blockview(@PathVariable String nowdate,@PathVariable int day){
        List<Block> blockview = blockService.blockview(nowdate, day);
        return blockview;
    }








}
