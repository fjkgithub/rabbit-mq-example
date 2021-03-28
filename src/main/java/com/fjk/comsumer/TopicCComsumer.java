package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "topic.c")
public class TopicCComsumer {
    @RabbitHandler
    public void recievedC(String message){
        System.out.println("topicC:"+message+"-"+ LocalDate.now());
    }
}
