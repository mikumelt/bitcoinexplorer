package io.dy.controller;

import io.dy.dao.Transaction_detailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
