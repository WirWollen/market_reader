package com.reader.read.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutputItemDto implements Serializable {
    private Long id;
    private Long price;
    private LocalDateTime timeChecking;
}
