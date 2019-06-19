package io.dy.bitcoinexplorer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan("io.dy")
@MapperScan("io.dy.dao")
@SpringBootApplication
@EnableFeignClients("io.dy.api")
@EnableScheduling
@EnableAsync
public class BitcoinexplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinexplorerApplication.class, args);
    }

}
