package com.parse.steam.redis;

import com.parse.steam.dtos.redis.OuterDto;

import java.util.Map;

public interface RedisRepo {
    OuterDto findById(Long id);

    Map<Long, OuterDto> findAll();
}
