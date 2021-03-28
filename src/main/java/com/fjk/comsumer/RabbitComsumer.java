package com.fjk.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "rabbit-mq-demo")
public class RabbitComsumer {
    @RabbitHandler
    private void recievedMessage(String message){
        System.out.println("消费信息："+message);
    }
}
