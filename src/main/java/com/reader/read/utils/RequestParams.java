package com.reader.read.utils;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RequestParams {
    private String url = "https://www.citilink.ru/graphql/";
    private String body = "{\n" +
            "    \"query\": \"query GetRecentlyViewed($input:Catalog_RecentlyViewedInput!){recommendations{recentlyViewedProducts(input:$input){...ProductSnippetBase}}}fragment ProductSnippetBase on Catalog_Product{id,name,shortName,slug,isAvailable,images{citilink{...Image}},price{...ProductPrice},category{id,name},brand{name},multiplicity}fragment Image on Image{sources{url,size}}fragment ProductPrice on Catalog_ProductPrice{current,old,club,clubPriceViewType}\",\n" +
            "    \"variables\": {\n" +
            "        \"input\": {\n" +
            "            \"limit\": 16\n" +
            "        }\n" +
            "    }\n" +
            "}";
}
