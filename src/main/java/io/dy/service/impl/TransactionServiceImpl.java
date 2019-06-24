package io.dy.service.impl;

import io.dy.dao.TransactionMapper;
import io.dy.po.Transaction;
import io.dy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    /**
     * 获取最近五条的交易
     * @return
     */
    @Override
    public List<Transaction> getRecentTransactions() {
        List<Transaction> transactionList = transactionMapper.selectRecentTransactions();
        return transactionList;
    }
}
