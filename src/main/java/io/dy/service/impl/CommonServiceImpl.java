package io.dy.service.impl;

import io.dy.dao.BlockMapper;
import io.dy.dao.TransactionMapper;
import io.dy.dao.Transaction_detailMapper;
import io.dy.po.Block;
import io.dy.po.Transaction;
import io.dy.po.Transaction_detail;
import io.dy.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @Override
    public Block selectByheight(String height) {
        Block block = blockMapper.selectByheight(height);
        return block;
    }

    @Override
    public Block selectByPrimaryKey(String blockhash) {
        Block block = blockMapper.selectByPrimaryKey(blockhash);
        return block;
    }

    @Override
    public Transaction selectByTxhash(String txhash) {
        Transaction transaction = transactionMapper.selectByPrimaryKey(txhash);
        return transaction;
    }

    @Override
    public List<Transaction_detail> selectByaddress(String address) {
        List<Transaction_detail> transaction_details = transaction_detailMapper.selectByaddress(address);
        return transaction_details;
    }

}
