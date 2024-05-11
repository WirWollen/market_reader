package com.parse.steam.redis;

import com.parse.steam.dtos.redis.OuterDto;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisRepoImpl implements RedisRepo {
    @Value(value = "${market}")
    private String redisKey;

    private final RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, OuterDto> hashOperations;

    @Autowired
    public RedisRepoImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public OuterDto findById(Long id) {
        return hashOperations.get(redisKey, id);
    }

    @Override
    public Map<Long, OuterDto> findAll() {
        return hashOperations.entries(redisKey);
    }
}
