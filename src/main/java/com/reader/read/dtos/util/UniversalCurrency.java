package com.reader.read.dtos.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UniversalCurrency {
    RUB("RUB", "PRICE_IN_RUB");

    private final String name;
    private final String marketName;
}
