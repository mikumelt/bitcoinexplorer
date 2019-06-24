package io.dy.service;

import io.dy.po.Transaction;

import java.util.List;

public interface TransactionService {

    //获取最近的交易
    List<Transaction> getRecentTransactions();
}
