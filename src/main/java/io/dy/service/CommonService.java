package io.dy.service;

import io.dy.po.Block;
import io.dy.po.Transaction;
import io.dy.po.Transaction_detail;

import java.util.List;

public interface CommonService {
    Block selectByheight(String height);

    Block selectByPrimaryKey(String blockhash);

    Transaction selectByTxhash(String txhash);

    List<Transaction_detail> selectByaddress(String adress);
}
