package io.dy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.dy.api.BitcoinJsonRpcApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc")
public class RpcApiController {

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;

    @GetMapping("/getbestblockhash")
    public String getbestblockhash() throws Throwable {
        String getbestblockhash = bitcoinJsonRpcApi.getbestblockhash();
        return getbestblockhash;
    }

    @GetMapping("/getBlockchainInfo")
    public String getBlockchainInfo() throws Throwable {
        JSONObject blockchainInfo = bitcoinJsonRpcApi.getBlockchainInfo();
        return blockchainInfo.toJSONString();
    }



}
