package com.reader.read.dtos.ctl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalSendDataDto {
    private String sdk;
    private String sdk_version;
    private String sdk_snippet_version;
    private List<CommandsDto> commands;
}
