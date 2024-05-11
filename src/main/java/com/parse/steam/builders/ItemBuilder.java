package com.parse.steam.builders;

import com.parse.steam.dtos.OutputItemDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemBuilder {
    public static OutputItemDto buildOutput(Long price, Long id) {
        var output = new OutputItemDto();
        output.setId(id);
        output.setPrice(price);
        output.setTimeChecking(LocalDateTime.now());

        return output;
    }
}
