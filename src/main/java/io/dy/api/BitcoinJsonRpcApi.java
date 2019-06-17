package io.dy.api;


import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpcApi {

    String getbestblockhash() throws Throwable;

    JSONObject getBlockchainInfo() throws Throwable;

    JSONObject getBlockByHash(String blockhash) throws Throwable;

    JSONObject getTransactionById(String txid) throws Throwable;

    String getBlockhashByHeight(Integer height) throws Throwable;


}
