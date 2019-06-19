package io.dy.controller;

import io.dy.dao.TransactionMapper;
import io.dy.dao.Transaction_detailMapper;
import io.dy.po.Transaction_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
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

}
