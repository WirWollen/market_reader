package com.parse.steam.builders;

import com.parse.steam.dtos.OutputItemDto;
import com.parse.steam.dtos.redis.OuterDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ItemBuilder {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static OutputItemDto buildOutput(Long price, OuterDto dto) {
        var output = new OutputItemDto();
        output.setId(dto.getId());
        output.setPrice(price);
        output.setTimeChecking(LocalDateTime.now().format(formatter));

        return output;
    }
}
