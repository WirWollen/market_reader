package com.reader.read.dtos.ctl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertiesDto {
    private String location;
    private String os;
    private String browser;
    private String device;
    private String referrer;
    private String path;
    private String activity;
    private String cookie;
}
