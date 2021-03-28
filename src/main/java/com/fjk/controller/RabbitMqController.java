package com.fjk.controller;

import com.fjk.produce.DelayedProducer;
import com.fjk.produce.FanoutProducer;
import com.fjk.produce.RabbitProducer;
import com.fjk.produce.TopicProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RabbitMqController {
    @Resource
    private RabbitProducer producer;
    @Resource
    private FanoutProducer fanoutProducer;
    @Resource
    private TopicProducer topicProducer;
    @Resource
    private DelayedProducer delayedProducer;

    @GetMapping("/sendDemoQueue")
    public String sendDemoQueue() {
        producer.sendMessage("test");
        return "success";
    }

    @GetMapping("/sendFanoutQueue")
    public String sendFanoutQueue() {
        fanoutProducer.sendFanoutMessage("fanout-message");
        return "success";
    }

    @GetMapping("/sendTopicQueueA")
    public String sendTopicQueue() {
        topicProducer.sendTopicAMessage("topicA-message");
        return "success";
    }
    @GetMapping("/sendTopicQueueB")
    public String sendTopicQueueB() {
        topicProducer.sendTopicBMessage("topicB-message");
        return "success";
    }
    @GetMapping("/sendTopicQueueC")
    public String sendTopicQueueC() {
        topicProducer.sendTopicCMessage("topicC-message");
        return "success";
    }

    @GetMapping("/delayedProducer")
    public String delayedProducer() {
        delayedProducer.delayedMessage();
        return "success";
    }

}
