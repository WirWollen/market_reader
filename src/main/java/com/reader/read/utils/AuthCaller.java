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
    private String bulk = "https://ctl-api.exponea.com/bulk";

//    @Scheduled(fixedRate = 600)
    public FullAuthDto result() {
        HttpHeaders headers = new HttpHeaders();
        String url = "/product/monitor-aoc-27-value-line-27b2h-00-01-chernyi-ips-led-5ms-16-9-hdmi-ma-1367499/";

        String url2 = "https://www.citilink.ru/product/noutbuk-infinix-inbook-y3-max-yl613-i5-1235u-16gb-ssd512gb-16-ips-fhd-1982262/";


        HttpHeaders headers1 = new HttpHeaders();


        ResponseEntity<String> responseEntity = restTemplate.exchange(url2, HttpMethod.GET, null, String.class);
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
                url,
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                tuid
        ), headers), FullAuthDto.class);

        return response.getBody();
    }
}
