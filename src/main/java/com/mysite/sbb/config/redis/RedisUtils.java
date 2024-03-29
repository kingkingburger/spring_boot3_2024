package com.mysite.sbb.config.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class RedisUtils {

  private final RedisTemplate<String, Object> redisTemplate;

  public void setData(String key, String value, Long expiredTime) {
    redisTemplate.opsForValue().set(key, value);
  }

  public String getData(String key) {
    return getRedisResult(key);
  }

  public void deleteData(String key) {
    getRedisResult(key);
    redisTemplate.delete(key);
  }

  private String getRedisResult(String key) {
    if (key == null) {
      throw new NotFoundException("key를 입력하지 않았습니다.");
    }
    String redisResult = (String) redisTemplate.opsForValue().get(key);
    if (redisResult == null) {
      throw new NotFoundException("Redis에서 해당 키에 대한 데이터를 찾을 수 없습니다." + key);
    }
    return redisResult;
  }
}
