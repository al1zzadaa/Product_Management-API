package com.example.product_managementapi.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportScheduler {

    @Scheduled(fixedRate = 5000)
    public void generator(){
        System.out.println("Generating Report " + "Time: " + LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 10000)
    public void delay(){
        System.out.println("Cleaning reports " + "Time: "+ LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void daily(){
        System.out.println("Daily Report " + "Time: " +LocalDateTime.now());
    }


}
