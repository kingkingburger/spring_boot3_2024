package com.mysite.sbb.cunsumer.service;

import com.mysite.sbb.cunsumer.vo.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

  @RabbitListener(queues = "${rabbitmq.queue}")
  public void getMessage(Message message) {
    log.error("### message => {}", message);
  }
}
