package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "fanout.c")
public class FanoutCcomsumer {
    @RabbitHandler
    public void recievedC(String message){
        System.out.println("fanoutC:"+message+"-"+ LocalDate.now());
    }
}
