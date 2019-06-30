package io.dy.service;

import io.dy.dto.BlockListDTO;
import io.dy.po.Block;

import java.util.Date;
import java.util.List;

public interface BlockService {
    //从数据库获取最近的块
    List<BlockListDTO> getRecentBlocks();

    List<Block> blockview(String nowdate,int day);
}
