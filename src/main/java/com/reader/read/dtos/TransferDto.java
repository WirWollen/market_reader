package com.reader.read.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    private Long tuidId;
    private Long price;
    private String currency;
    private LocalDateTime dateTime;
    private Boolean inMarket;
    private String tuid;
}
