package com.reader.read.dtos.ctl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {
    private String project_id;
    private String company_id;
    private String type;
    private Double age;
    private PropertiesDto properties;
    private String cookie;
    private CustomerDto customer;
    private CustomerIdsDto customer_ids;
    private Long expires;
    private Double timestamp;
}
