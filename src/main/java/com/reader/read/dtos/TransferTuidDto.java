package com.reader.read.dtos;

import com.reader.read.dtos.citilink.Element;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferTuidDto {
    private Element responseElement;
    private String tuid;
}
