package io.dy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.dy.api.BitcoinRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@EnableAutoConfiguration
public class RestApiController {

    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @GetMapping("/chaininfo")
    public String getBlockChainInfo(){
        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        return blockChainInfo.toJSONString();
    }

    @GetMapping("/tx/{txhash}")
    public String getTransactionsByhash(@PathVariable String txhash){
        JSONObject transactionsByhash = bitcoinRestApi.getTransactionsByhash(txhash);
        return transactionsByhash.toJSONString();
    }

    @GetMapping("/block/{blockhash}")
    public String getBlockByblockhash(@PathVariable String blockhash){
        JSONObject blockByblockhash = bitcoinRestApi.getBlockByblockhash(blockhash);
        return blockByblockhash.toJSONString();
    }

    @GetMapping("/block/notxdetails/{blockhash}")
    public String getBlockBynotxdetailsblockhash(@PathVariable String blockhash){
        JSONObject blockBynotxdetailsblockhash = bitcoinRestApi.getBlockBynotxdetailsblockhash(blockhash);
        return blockBynotxdetailsblockhash.toJSONString();
    }

    @GetMapping("/headers/{count}/{blockhash}")
    public JSONArray getBlockheaders(@PathVariable Integer count, @PathVariable String blockhash){
        JSONArray blockheaders = bitcoinRestApi.getBlockheaders(count, blockhash);
        return blockheaders;
    }

    @GetMapping("/blockhashbyheight/{height}")
    public String getblockhashbyheight(@PathVariable Integer height){
        JSONObject getblockhashbyheight = bitcoinRestApi.getblockhashbyheight(height);
        return getblockhashbyheight.toJSONString();
    }

    @GetMapping("/mempool/info")
    public String getmempool(){
        JSONObject getmempool = bitcoinRestApi.getmempool();
        return getmempool.toJSONString();
    }

    @GetMapping("/mempool/contents")
    public String getmempoolcontents(){
        JSONObject getmempoolcontents = bitcoinRestApi.getmempoolcontents();
        return getmempoolcontents.toJSONString();
    }




}
