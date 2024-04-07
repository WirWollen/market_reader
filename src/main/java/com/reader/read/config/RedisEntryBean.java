package com.reader.read.config;

import com.reader.read.dtos.redis.OuterDto;
import com.reader.read.redis.CitilinkRedisRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisEntryBean {
    @Autowired
    private CitilinkRedisRepoImpl citilink;

    private Map<Long, OuterDto> citilinkItems = null;

    @Bean
    public Map<Long, OuterDto> getCitilinkItems() {
        if (citilinkItems == null) {
            updateCitilinkItems();
        }
        return citilinkItems;
    }

    @Bean
    public boolean updateCitilinkItems() {
        citilinkItems = citilink.findAll();
        return true;
    }
}
