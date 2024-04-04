package com.mysite.sbb.producer.controller;

import com.mysite.sbb.producer.service.RabbitmqService;
import com.mysite.sbb.producer.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {

  @Autowired RabbitmqService rabbitmqService;

  @RequestMapping(value = "/send")
  public Message send(Message message) {
    rabbitmqService.addQueue(message);
    return message;
  }
}
