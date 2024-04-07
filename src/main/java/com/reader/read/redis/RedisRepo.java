package com.reader.read.redis;

import com.reader.read.dtos.redis.OuterDto;

import java.util.Map;

public interface RedisRepo {
    OuterDto findById(Long id);

    Map<Long, OuterDto> findAll();
}
