package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "fanout.b")
public class FanoutBComsumer {
    @RabbitHandler
    public void recievedB(String message){
        System.out.println("fanoutB:"+message+"-"+ LocalDate.now());
    }
}
