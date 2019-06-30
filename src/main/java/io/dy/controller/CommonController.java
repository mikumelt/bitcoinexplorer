package io.dy.controller;

import com.alibaba.fastjson.JSONObject;
import io.dy.api.BlockChainRestApi;
import io.dy.dto.TickerDTO;
import io.dy.po.Block;
import io.dy.po.Transaction;
import io.dy.service.CommonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private BlockChainRestApi blockChainRestApi;

    // todo Address,Transaction,or Block height

    /**
     * 先进行参数校验 判断参数属于其中哪个
     * 返回带参地址 前台进行跳转
     * @param value
     * @return
     */
    @GetMapping("/search/{value}")
    public String search(@PathVariable String value){
        String parameter =value;

        if("".equals(parameter)){
            //参数不能为空
            return "bitcoinhelp";
        }
        //先对高度进行校验
        if(parameter.length()<8){
            return "bitcoinblock?height="+parameter;
        }

        //正则匹配 区分 Transaction,orBlock
        String regString = "[a-f0-9A-F]{64}";
        if(Pattern.matches(regString,parameter)){
            Block block = commonService.selectByPrimaryKey(parameter);
            if(block!=null){
                return "bitcoinblockhash?blockhash="+parameter;
            }
            Transaction transaction = commonService.selectByTxhash(parameter);
            if(transaction!=null){
                return "bitcoindetail?txhash="+parameter;
            }
        }else{
            //地址的处理
            return "bitcoinqrcode?address="+parameter;
        }
        //输入的参数有误
        return  "bitcoinhelp";
    }

    @MessageMapping("/pushRecentBlock")
    @SendTo("/mytopic/pushRecentBlock")
    public String pushRecentBlock(String message){
        return message;
    }



    @GetMapping("/ticker")
    public String getRecentTicker(){
        JSONObject recentTicker = blockChainRestApi.getRecentTicker();
        return recentTicker.toJSONString();
    }

    @GetMapping("/addresstohash/{address}")
    public String addresstohash(@PathVariable String address){
        String addresstohash = blockChainRestApi.addresstohash(address);
        return addresstohash;
    }

    @GetMapping("/getdifficulty")
    public String getdifficulty(){
        String getdifficulty = blockChainRestApi.getdifficulty();
        return getdifficulty;
    }

}
