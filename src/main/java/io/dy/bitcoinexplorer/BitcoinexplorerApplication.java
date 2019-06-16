package io.dy.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("io.dy")
@MapperScan("io.dy.dao")
@SpringBootApplication
@EnableFeignClients("io.dy.api")
public class BitcoinexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinexplorerApplication.class, args);
    }

}
