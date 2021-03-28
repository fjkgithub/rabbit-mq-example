package com.fjk.produce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

@Component
public class RabbitProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        LocalDate localDate = LocalDate.now();
        System.out.println("生产者："+message+"，时间："+localDate);
        rabbitTemplate.convertAndSend("rabbit-mq-demo",message+"-"+localDate);
    }
}
