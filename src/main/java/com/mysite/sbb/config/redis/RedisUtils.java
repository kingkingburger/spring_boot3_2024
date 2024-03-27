package com.mysite.sbb.config.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisUtils {

  private final RedisTemplate<String, Object> redisTemplate;

  public void setData(String key, String value, Long expiredTime) {
    System.out.println("key = " + key);
    System.out.println("value = " + value);
    redisTemplate.opsForValue().set(key, value);
  }

  public String getData(String key) {
    return (String) redisTemplate.opsForValue().get(key);
  }

  public void deleteData(String key) {
    redisTemplate.delete(key);
  }
}
