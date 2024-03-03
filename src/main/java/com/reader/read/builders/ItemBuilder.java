package com.reader.read.builders;

import com.reader.read.dtos.OutputItemDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ItemBuilder {
    public static OutputItemDto buildOutput(Long price, Long id, Integer marketId) {
        var output = new OutputItemDto();
        output.setId(id);
        output.setPrice(price);
        output.setMarketId(marketId);
        output.setTimeChecking(LocalDateTime.now());

        return output;
    }
}
