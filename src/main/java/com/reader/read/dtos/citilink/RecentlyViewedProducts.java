package com.reader.read.dtos.citilink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecentlyViewedProducts {
    private String id;
    private String name;
    private String shortName;
    private String slug;
    private Boolean isAvailable;
    private Images images;
    private Price price;
    private Category category;
    private Brand brand;
    private int multiplicity;
}
