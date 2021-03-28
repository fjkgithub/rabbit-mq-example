package com.fjk.config;

import com.fjk.contanct.DelayedTopic;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitConfig {
    @Bean
    public Queue createQueue(){
        return new Queue("rabbit-mq-demo");
    }

    //=================== fanout广播模式  ====================

    @Bean
    public Queue fanoutA() {
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutB() {
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutC() {
        return new Queue("fanout.c");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Binding bindingExchangeWithA(){
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithB(){
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithC(){
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }

    //=================== topic主题模式  ====================

    @Bean
    public Queue topicA() {
        return new Queue("topic.a");
    }

    @Bean
    public Queue topicB() {
        return new Queue("topic.b");
    }

    @Bean
    public Queue topicC() {
        return new Queue("topic.c");
    }

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding topicBindExchangeTopicA(){
        return BindingBuilder.bind(topicA()).to(topicExchange()).with("topicA.message");
    }

    @Bean
    public Binding topicBindExchangeTopicB(){
        return BindingBuilder.bind(topicB()).to(topicExchange()).with("topic.#");
    }

    @Bean
    public Binding topicBindExchangeTopicC(){
        return BindingBuilder.bind(topicC()).to(topicExchange()).with("topic.*");
    }

    //===================延迟队列======================
    /**
     * 初始化延时队列
     *
     * @return
     */
    @Bean
    public Queue delayedQueue() {
        return new Queue(DelayedTopic.DELAYED_QUEUE_NAME);
    }

    /**
     * 定义一个延迟交换机
     *
     * @return
     */
    @Bean
    public CustomExchange delayExchange() {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DelayedTopic.DELAYED_EXCHANGE_NAME, "x-delayed-message", true, false, args);
    }

    /**
     * 绑定队列到这个延迟交换机上
     *
     * @param queue
     * @param customExchange
     * @return
     */
    @Bean
    public Binding bindingNotify(@Qualifier("delayedQueue") Queue queue,
                                 @Qualifier("delayExchange") CustomExchange customExchange) {
        return BindingBuilder.bind(queue).to(customExchange).with(DelayedTopic.DELAYED_ROUTING_KEY).noargs();
    }

}
