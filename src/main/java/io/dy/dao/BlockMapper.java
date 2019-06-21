package io.dy.dao;

import io.dy.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(String blockhash);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(String blockhash);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> selectRecentBlocks();

    Block selectByheight(@Param("height") String height);



}