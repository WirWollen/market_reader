package com.reader.read.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullAuthDto {
    private List<ResultDto> results;
    private Double start_time;
    private Double end_time;
    private Boolean success;
}
