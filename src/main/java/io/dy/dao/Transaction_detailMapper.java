package io.dy.dao;

import io.dy.po.Transaction_detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Transaction_detailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(Transaction_detail record);

    int insertSelective(Transaction_detail record);

    Transaction_detail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(Transaction_detail record);

    int updateByPrimaryKey(Transaction_detail record);

    //获取账户余额
    Double getBanlance(@Param("address") String address);

    //根据交易哈希值获取交易的集合
    List<Transaction_detail> getDetailBytxid(@Param("txhash") String txhash);

    List<Transaction_detail> selectByaddress(@Param("address") String address);

}