package io.dy.dao;

import io.dy.po.Block;
import io.dy.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(String txhash);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(String txhash);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> selectRecentTransactions();

    List<Transaction> transactionview(String nowdate,int day);

}