package com.reader.read.dtos.citilink;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommendations {
    private List<RecentlyViewedProducts> recentlyViewedProducts;
}
