package io.dy.controller;

import io.dy.po.Block;
import io.dy.po.Transaction;
import io.dy.po.Transaction_detail;
import io.dy.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/common")
@CrossOrigin
public class CommonController {

    @Autowired
    private CommonService commonService;

    // todo Address,Transaction,orBlock height

    /**
     * 先进行参数校验 判断参数属于其中哪个
     * @param value
     * @return
     */
    @GetMapping("/search/{value}")
    public Object search(@PathVariable String value){
        String parameter =value;

        if(parameter=="" && parameter == null){
            return "参数不能为空!";
        }
        //先对高度进行校验
        if(parameter.length()<8){
            Block block = commonService.selectByheight(parameter);
            if(block!=null){
                return block;
            }

        }
        //正则匹配 区分 Transaction,orBlock
        String regString = "[a-f0-9A-F]{64}";
        if(Pattern.matches(regString,parameter)){
            Block block = commonService.selectByPrimaryKey(parameter);
            if(block!=null){
                return block;
            }
            Transaction transaction = commonService.selectByTxhash(parameter);
            if(transaction!=null){
                return transaction;
            }
        }else{
            List<Transaction_detail> transaction_details = commonService.selectByaddress(parameter);
            if(transaction_details!=null){
                return transaction_details;
            }
        }

        return  "输入的参数有误!";
    }

    @MessageMapping("/pushRecentBlock")
    @SendTo("/mytopic/pushRecentBlock")
    public String pushRecentBlock(String message){
        return message;
    }






}
