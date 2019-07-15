package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feignClient.CommentClient;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceLayer {

    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY = "create.controller";

    @Autowired
    private RabbitTemplate rabbitTemplate;
    private CommentClient commentClient;
}
