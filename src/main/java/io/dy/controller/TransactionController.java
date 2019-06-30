package io.dy.controller;

import io.dy.dao.TransactionMapper;
import io.dy.dao.Transaction_detailMapper;
import io.dy.po.Transaction;
import io.dy.po.Transaction_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @GetMapping("/getDetailBytxid/{txhash}")
    public List<Transaction_detail> getDetailBytxid(@PathVariable String txhash){
        List<Transaction_detail> detailBytxid = transaction_detailMapper.getDetailBytxid(txhash);
        return detailBytxid;
    }

    @GetMapping("/getRecentTransactions")
    public List<Transaction> getRecentTransactions(){
        List<Transaction> transactionList = transactionMapper.selectRecentTransactions();
        return transactionList;
    }

    @GetMapping("/transactionview/{nowdate}/{day}")
    public List<Transaction> transactionview(@PathVariable String nowdate,@PathVariable  int day){
        List<Transaction> transactionview = transactionMapper.transactionview(nowdate, day);
        return transactionview;
    }


}
