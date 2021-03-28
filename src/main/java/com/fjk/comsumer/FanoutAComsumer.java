package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "fanout.a")
public class FanoutAComsumer {
    @RabbitHandler
    public void recievedA(String message){
        System.out.println("fanoutA:"+message+"-"+ LocalDate.now());
    }
}
