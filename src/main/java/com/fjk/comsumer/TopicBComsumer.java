package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RabbitListener(queues = "topic.b")
public class TopicBComsumer {
    @RabbitHandler
    public void recievedB(String message){
        System.out.println("topicB:"+message+"-"+ LocalDate.now());
    }
}
