package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "topic.a")
public class TopicAComsumer {
    @RabbitHandler
    public void recievedA(String message){
        System.out.println("topicA:"+message+"-"+ LocalDate.now());
    }
}
