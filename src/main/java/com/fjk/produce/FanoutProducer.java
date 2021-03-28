package com.fjk.produce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;

@Component
public class FanoutProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendFanoutMessage(String message){
        LocalDate localDate = LocalDate.now();
        System.out.println("生产者："+message+"-"+localDate);
        rabbitTemplate.convertAndSend("fanoutExchange","",message+"-"+localDate);
    }
}
