package io.dy.scheduler;

import com.alibaba.fastjson.JSONObject;
import io.dy.api.BlockChainRestApi;
import io.dy.dao.TransactionMapper;
import io.dy.dto.BlockListDTO;
import io.dy.po.Transaction;
import io.dy.service.BlockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时推送最新的区块信息到页面
 */
@Component
public class TashScheduler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BlockService blockService;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private BlockChainRestApi blockChainRestApi;

    //@Scheduled(fixedRate = 3000)
    @Scheduled(cron = "${bitcoin.sync.cront}")
    public  void  sendData(){
        logger.info("begin to send data");
        List<BlockListDTO> recentBlocks = blockService.getRecentBlocks();
        simpMessagingTemplate.convertAndSend("/mytopic/pushRecentBlock",recentBlocks);
    }

    //@Scheduled(fixedRate = 3000)
    @Scheduled(cron = "${bitcoin.sync.cront}")
    public  void  sendData1(){
        logger.info("begin to send Data1");
        List<Transaction> transactionList = transactionMapper.selectRecentTransactions();
        simpMessagingTemplate.convertAndSend("/mytopic/pushTransactions",transactionList);
    }

    @Scheduled(fixedRate = 3000)
    public void sendTicker(){
        //实时推送 bitcoin 兑换 美元 的金额
        logger.info("begin to send Ticker");
        JSONObject recentTicker = blockChainRestApi.getRecentTicker();
        JSONObject usd = recentTicker.getJSONObject("USD");
        Double last = usd.getDouble("last");
        simpMessagingTemplate.convertAndSend("/mytopic/pushticker",last);
    }

    @Scheduled(fixedRate = 3000)
    public void sendDiffcult(){
        //实时 挖矿难度
        logger.info("begin to send Diffcult");
        String getdifficulty = blockChainRestApi.getdifficulty();
        simpMessagingTemplate.convertAndSend("/mytopic/pushdiffcult",getdifficulty);
    }


}
