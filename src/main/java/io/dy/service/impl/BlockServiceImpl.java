package io.dy.service.impl;

import io.dy.dao.BlockMapper;
import io.dy.dto.BlockListDTO;
import io.dy.po.Block;
import io.dy.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    //显示最近五条的数据
    @Override
    public List<BlockListDTO> getRecentBlocks() {
        List<BlockListDTO> blockListDTOS = new ArrayList<>();

        List<Block> blocks = blockMapper.selectRecentBlocks();

        for (Block block : blocks) {
            BlockListDTO blockListDTO = new BlockListDTO();
            blockListDTO.setBlockhash(block.getBlockhash());
            blockListDTO.setHeight(block.getHeight());
            blockListDTO.setTime(block.getTime());
            blockListDTO.setTxsize(block.getTxsize());
            blockListDTO.setSize(block.getSize());
            blockListDTOS.add(blockListDTO);
        }
        return blockListDTOS;
    }


}
