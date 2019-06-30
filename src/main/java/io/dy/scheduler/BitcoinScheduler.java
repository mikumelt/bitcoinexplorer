package io.dy.scheduler;

import io.dy.service.BitcoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BitcoinScheduler {

    //日志
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinService bitcoinService;

    //同步数据库
    @Scheduled(fixedRate = 600000)
    public void syncData() throws Throwable {
        logger.info("begin to sync bitcoin data");

        //00000000000002c99371b6405b156cf1790eea8c19b6fe315408463d0d7b2375

        //000000000001b85bd7d28ce0433bb17193c7d9914a2b213ba5760ad5e35cd177


//        String tempBlockhash = "000000000001b85bd7d28ce0433bb17193c7d9914a2b213ba5760ad5e35cd177";
//        bitcoinService.syncBlockchainByHash(tempBlockhash);
    }

}
