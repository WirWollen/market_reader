package com.reader.read.converters;

import com.reader.read.dtos.TransferDto;
import com.reader.read.dtos.TransferTuidDto;
import com.reader.read.dtos.citilink.RecentlyViewedProducts;
import com.reader.read.dtos.util.BrandMapper;
import com.reader.read.dtos.util.UniversalCurrency;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CitilinkToDatabaseConverter {
    private BrandMapper brandMapper;

    public TransferDto toCookie(TransferTuidDto transfer) {
        TransferDto response = new TransferDto();
        var last = transfer.getResponseElement().getData().getRecommendations().getRecentlyViewedProducts();
        RecentlyViewedProducts test = last.get(last.size() - 1);

        response.setCurrency(UniversalCurrency.RUB.getMarketName());
        response.setPrice(Long.valueOf(test.getPrice().getCurrent()));
        response.setTuid(transfer.getTuid());
        response.setDateTime(LocalDateTime.now());
        response.setInMarket(true);

        return response;
    }
}
