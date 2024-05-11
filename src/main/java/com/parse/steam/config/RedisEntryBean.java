package com.parse.steam.config;

import com.parse.steam.dtos.redis.OuterDto;
import com.parse.steam.redis.RedisRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisEntryBean {
    @Autowired
    private RedisRepoImpl citilink;

    private Map<Long, OuterDto> citilinkItems = null;

    @Bean
    public Map<Long, OuterDto> getCitilinkItems() {
        if (citilinkItems == null) {
            updateCitilinkItems();
        }
        return citilink.findAll();
    }

    @Bean
    public boolean updateCitilinkItems() {
        citilinkItems = citilink.findAll();
        return true;
    }
}
