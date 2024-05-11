package com.parse.steam.dtos.redis;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ShopName {
    CITILINK("citilink"),
    DNS("dns");

    private final String name;
}
