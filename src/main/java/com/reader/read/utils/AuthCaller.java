package com.reader.read.utils;

import com.reader.read.dtos.auth.FullAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AuthCaller {
    @Autowired
    private Auth auth;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String bulk = "https://ctl-api.exponea.com/bulk";

    public FullAuthDto result() {
        HttpHeaders headers = new HttpHeaders();
        String url = "https://www.citilink.ru";
        String url2 = "/product/noutbuk-infinix-inbook-y3-max-yl613-i5-1235u-16gb-ssd512gb-16-ips-fhd-1982262/";


        ResponseEntity<String> responseEntity = restTemplate.exchange(url + url2, HttpMethod.GET, null, String.class);
        HttpHeaders headers2 = responseEntity.getHeaders();
        String tuidComplex = headers2.get("set-cookie").get(0);

        String regex = "(_tuid=[^;]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(tuidComplex);

        String tuid = null;

        if (matcher.find()) {
            tuid = matcher.group();
        }

        ResponseEntity<FullAuthDto> response = restTemplate.postForEntity(bulk, new HttpEntity<>(auth.generateGlobalSendDataDto(
                url2,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                tuid
        ), headers), FullAuthDto.class);

        return response.getBody();
    }
}
