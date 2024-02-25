package com.reader.read.dtos.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BrandMapper {
    //TODO mock
    private final Map<UniversalBrand, List<String>> hashedItems = new HashMap<>();

    public UniversalBrand findKeyByValue(String value) {
        hashedItems.put(UniversalBrand.AOC, List.of("AOC", "aoc"));

        for (Map.Entry<UniversalBrand, List<String>> entry : hashedItems.entrySet()) {
            if (entry.getValue().contains(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
