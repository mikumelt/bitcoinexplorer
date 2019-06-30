package io.dy.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BlockChainRestApi",url = "https://blockchain.info")
public interface BlockChainRestApi {

    //滞后15分钟的市场价格
    @GetMapping("/ticker")
    JSONObject getRecentTicker();

    //返回所指定地址对应的hash160。
    @GetMapping("/q/addresstohash/{address}")
    String addresstohash(@PathVariable String address);

    //获取当前难度目标
    @GetMapping("/q/getdifficulty")
    String getdifficulty();
}
