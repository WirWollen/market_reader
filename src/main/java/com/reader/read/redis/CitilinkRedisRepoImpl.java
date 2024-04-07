package com.reader.read.redis;

import com.reader.read.dtos.redis.OuterDto;
import com.reader.read.dtos.redis.ShopName;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CitilinkRedisRepoImpl implements RedisRepo {
    private static final String CITILINK = ShopName.CITILINK.getName();

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, OuterDto> hashOperations;

    @Autowired
    public CitilinkRedisRepoImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public OuterDto findById(Long id) {
        return hashOperations.get(CITILINK, id);
    }

    @Override
    public Map<Long, OuterDto> findAll() {
        return hashOperations.entries(CITILINK);
    }
}
