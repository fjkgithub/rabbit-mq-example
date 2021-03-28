package com.fjk.produce;

import com.fjk.contanct.DelayedTopic;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Component
public class DelayedProducer {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void delayedMessage() {
        String context = "延迟6s的消息";
        System.out.println("生产时间: " + LocalDateTime.now() + "内容: " + context);
        //延时时间6秒
        rabbitTemplate.convertAndSend(DelayedTopic.DELAYED_EXCHANGE_NAME, DelayedTopic.DELAYED_ROUTING_KEY, context, a -> {
            a.getMessageProperties().setDelay(6000);
            return a;
        });
    }
}
