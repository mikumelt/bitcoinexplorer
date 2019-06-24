package io.dy.scheduler;

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

    @Scheduled(fixedRate = 3000)
    public  void  sendData(){
        logger.info("begin to send data");
        List<BlockListDTO> recentBlocks = blockService.getRecentBlocks();
        simpMessagingTemplate.convertAndSend("/mytopic/pushRecentBlock",recentBlocks);
    }

    @Scheduled(fixedRate = 3000)
    public  void  sendData1(){
        logger.info("begin to send data");
        List<Transaction> transactionList = transactionMapper.selectRecentTransactions();
        simpMessagingTemplate.convertAndSend("/mytopic/pushTransactions",transactionList);
    }


}
