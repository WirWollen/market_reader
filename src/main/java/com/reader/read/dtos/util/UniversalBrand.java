package com.reader.read.dtos.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum UniversalBrand {
    AOC(1L, "AOC");

    private final Long id;
    private final String name;
}
