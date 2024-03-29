package io.dy.dao;

import io.dy.dto.BlockListDTO;
import io.dy.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    List<Block> blockview(@Param("nowdate") String nowdate,@Param("day") int day);



}