package com.fjk.produce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

@Component
public class TopicProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendTopicAMessage(String message){
        LocalDate localDate = LocalDate.now();
        System.out.println("生产者A："+message+"-"+localDate);
        rabbitTemplate.convertAndSend("topicExchange","topicA.message",message+"-"+localDate);
    }

    public void sendTopicBMessage(String message){
        LocalDate localDate = LocalDate.now();
        System.out.println("生产者B："+message+"-"+localDate);
        rabbitTemplate.convertAndSend("topicExchange","topic.fdfdfdfd.fdfdfdf.fdfdfdf",message+"-"+localDate);
    }

    public void sendTopicCMessage(String message){
        LocalDate localDate = LocalDate.now();
        System.out.println("生产者C："+message+"-"+localDate);
        rabbitTemplate.convertAndSend("topicExchange","topic.fdfdfdfd",message+"-"+localDate);
        //rabbitTemplate.convertAndSend("topicExchange","topic.fdfs",message+"-"+localDate);
    }
}
