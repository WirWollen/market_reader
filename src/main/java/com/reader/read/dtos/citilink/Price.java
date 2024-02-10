package com.reader.read.dtos.citilink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    private String current;
    private String old;
    private String club;
    private String clubPriceViewType;
}
