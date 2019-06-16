package io.dy.controller;

import io.dy.dto.BlockGetDTO;
import io.dy.dto.BlockListDTO;
import io.dy.po.Block;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){
        List<BlockListDTO> list = new ArrayList<>();

        BlockListDTO blockListDTO = new BlockListDTO();
        blockListDTO.setBlockhash("00000000000002160e501d80be1463a6210eccf8a400ebb55fb4cb4549947b48");
        blockListDTO.setHeight(1543589);
        blockListDTO.setTime(new Date());
        blockListDTO.setTxsize(35);
        blockListDTO.setChainwork("00000000000000000000000000000000000000000000011b0ce0c84102692201");
        blockListDTO.setSize(12805);
        list.add(blockListDTO);


        BlockListDTO blockListDTO1 = new BlockListDTO();
        blockListDTO1.setBlockhash("00000000000002940ade0c2b454b0c3b8b9606725c47ee6fffcdd68c5e9e435c");
        blockListDTO1.setHeight(1543644);
        blockListDTO1.setTime(new Date());
        blockListDTO1.setTxsize(8);
        blockListDTO1.setChainwork("00000000000000000000000000000000000000000000011b0ce0c84102692201");
        blockListDTO1.setSize(2133);
        list.add(blockListDTO1);
        return list;
    }

    @GetMapping("/getByBlockhash/{blockhash}")
    public BlockGetDTO getByBlockhash(@PathVariable String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330");
        blockGetDTO.setConfirmations(1);
        blockGetDTO.setStrippedsize(18186);
        blockGetDTO.setSize(36317);
        blockGetDTO.setTxsize(111);
        blockGetDTO.setWeight(90875);
        blockGetDTO.setHeight(1543652);
        blockGetDTO.setVersion(536928256);
        blockGetDTO.setMerkleroot("e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5");
        blockGetDTO.setTime(new Date());
        blockGetDTO.setReceivedTime(new Date());
        blockGetDTO.setNonce(214911287);
        blockGetDTO.setDifficulty(4194304);
        blockGetDTO.setChainwork("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
        blockGetDTO.setPrevBlock("00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184");
        blockGetDTO.setNextBlock("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
        blockGetDTO.setOutputTotal(4465.02389308);
        blockGetDTO.setFees(0.63557721);
        blockGetDTO.setBlockReward(12.5);
        blockGetDTO.setRelayedBy("AntPool");
        List<String> list = new ArrayList<>();
        list.add("4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb");
        list.add("4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3");
        list.add("9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4");
        list.add("8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf");
        list.add("9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82");
        list.add("9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889");
        list.add("563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01");
        list.add("6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408");
        blockGetDTO.setTransactionList(list);
        return blockGetDTO;
    }

    @GetMapping("/getByHeight/{height}")
    public BlockGetDTO getByHeight(@PathVariable Integer height){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setBlockhash("0000000000000061aa4efcb9e905c9a41c6c7dc771a8c1a7ec1c45285e851330");
        blockGetDTO.setConfirmations(1);
        blockGetDTO.setStrippedsize(18186);
        blockGetDTO.setSize(36317);
        blockGetDTO.setTxsize(111);
        blockGetDTO.setWeight(90875);
        blockGetDTO.setHeight(1543652);
        blockGetDTO.setVersion(536928256);
        blockGetDTO.setMerkleroot("e74f9233b4c8ca860710ed7a3b67797b727efec1e324933dbc903a7ecbe488f5");
        blockGetDTO.setTime(new Date());
        blockGetDTO.setReceivedTime(new Date());
        blockGetDTO.setNonce(214911287);
        blockGetDTO.setDifficulty(4194304);
        blockGetDTO.setChainwork("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
        blockGetDTO.setPrevBlock("00000000000000067aac0c037e978fd5ddc0c16560ea541fa09a92479ec7f184");
        blockGetDTO.setNextBlock("00000000000000000000000000000000000000000000011b1c60d7c211ea3182");
        blockGetDTO.setOutputTotal(4465.02389308);
        blockGetDTO.setFees(0.63557721);
        blockGetDTO.setBlockReward(12.5);
        blockGetDTO.setRelayedBy("AntPool");
        List<String> list = new ArrayList<>();
        list.add("4267ab3453217020610c57497408524123e65538108425f476a01520eb083dfb");
        list.add("4936e12a4c213021d29cb7bfebe604b60b4c2e4ec416d23f25a1ae609226bfc3");
        list.add("9f12c5562afce30e331e783452994d23e8db40126539fc00631f88a584943cf4");
        list.add("8dbf870755ec560a004364e2c8823b331b66e1d5f682be02a7fa5967359d45bf");
        list.add("9283db04e55b6db4ef174fca723b5a35d7725fe60d169b59fb82bb8ae72aac82");
        list.add("9c10e90529d9a3882874184a5ba6e66b60d85062a1414d3e648baa197d490889");
        list.add("563785a73a18d36a05cef8b855a6f58c91d28907de8c3c58cd818dbdecb51c01");
        list.add("6e74634e3a582c671ed50da17c92b5b183c5d6c078d4543dc669b8a59041c408");
        blockGetDTO.setTransactionList(list);
        return blockGetDTO;
    }






}
