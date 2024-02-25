package com.reader.read.utils;

import com.reader.read.dtos.auth.FullAuthDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class ResponseHeader {
    private final RestTemplate restTemplate = new RestTemplate();

    public String generateHeader() {
        String url = "https://www.citilink.ru/product/noutbuk-infinix-inbook-y3-max-yl613-i5-1235u-16gb-ssd512gb-16-ips-fhd-1982262/";

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        HttpHeaders headers = responseEntity.getHeaders();

        return headers.get(0).get(0);
    }
}
