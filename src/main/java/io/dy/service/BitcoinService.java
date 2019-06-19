package io.dy.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public interface BitcoinService {
    // 同步 区块链
    void syncBlockchainByHash(String blockhash) throws Throwable;
    //同步 块到数据库
    String syncBlock(String blockhash) throws Throwable;
    //同步 交易信息到数据库
    void syncTransaction(JSONObject transactionJson,String blockhash, Date time, Integer confirmations ) throws Throwable;
    //同步 交易详情
    void syncTransaction_detail(JSONObject transactionJson,String txid) throws Throwable;
    // 同步 花费金额
    void syncTransaction_detailVout(JSONArray vouts,String txid) throws Throwable;
    // 同步 余额 UTXO
    void syncTransaction_detailVin(JSONArray vins,String txid) throws Throwable;
}
