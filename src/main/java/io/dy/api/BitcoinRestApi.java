package io.dy.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BitcoinRestApi",url = "http://localhost:18332")
public interface BitcoinRestApi {

    @GetMapping("/rest/chaininfo.json")
    JSONObject getBlockChainInfo();

    @GetMapping("/rest/tx/{txhash}.json")
    JSONObject getTransactionsByhash(@PathVariable String txhash);

    @GetMapping("/rest/block/{blockhash}.json")
    JSONObject getBlockByblockhash(@PathVariable String blockhash);

    @GetMapping("/rest/block/notxdetails/{blockhash}.json")
    JSONObject getBlockBynotxdetailsblockhash(@PathVariable String blockhash);

    @GetMapping("/rest/headers/{count}/{blockhash}.json")
    List<JSONObject> getBlockheaders(@PathVariable Integer count, @PathVariable String blockhash);

    @GetMapping("/rest/blockhashbyheight/{height}.json")
    String getblockhashbyheight(@PathVariable Integer height);

    @GetMapping("/rest/mempool/info.json")
    JSONObject getmempool();

    @GetMapping("/rest/mempool/contents.json")
    JSONObject getmempoolcontents();

    @GetMapping("/rest/getutxos/{txid}-{n}.json")
    JSONObject getUTXO(@PathVariable String txid, @PathVariable Integer n);

    @GetMapping("/rest/getutxos/checkmempool/{txid}-{n}.json")
    JSONObject getUTXOCheckMempool(@PathVariable String txid, @PathVariable Integer n);





}
