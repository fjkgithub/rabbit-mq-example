package com.fjk.comsumer;

import com.fjk.contanct.DelayedTopic;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DelayedComsumer {

    @RabbitListener(queues = DelayedTopic.DELAYED_QUEUE_NAME)
    public void receive(String message) {
        System.out.println("消费时间: " + LocalDateTime.now() + "内容: " + message);
    }
}
