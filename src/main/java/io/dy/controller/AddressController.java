package io.dy.controller;

import io.dy.dao.Transaction_detailMapper;
import io.dy.po.Transaction_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adress")
@CrossOrigin
public class AddressController {

    @Autowired
    private Transaction_detailMapper transaction_detailMapper;

    @GetMapping("/getBanlance/{address}")
    public Double getBanlance(@PathVariable String address){
        Double banlance = transaction_detailMapper.getBanlance(address);
        return banlance;
    }

    @GetMapping("/selectByaddress/{address}")
    public List<Transaction_detail> selectByaddress(@PathVariable String address){
        List<Transaction_detail> transaction_details = transaction_detailMapper.selectByaddress(address);
        return transaction_details;
    }
}
