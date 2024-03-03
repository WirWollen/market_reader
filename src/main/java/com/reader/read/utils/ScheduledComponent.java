package com.reader.read.utils;

import com.reader.read.converters.CitilinkToDatabaseConverter;
import com.reader.read.dtos.TransferTuidDto;
import com.reader.read.dtos.citilink.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class ScheduledComponent {
    @Autowired
    private RequestParams requestParams;
    @Autowired
    private CookieGenerator cookieGenerator;
    @Autowired
    private CitilinkToDatabaseConverter citilink;
    @Autowired
    private AuthCaller authCaller;
    private final RestTemplate restTemplate = new RestTemplate();

//    @Scheduled(fixedRate = 60000)
    public void test() {
        HttpHeaders headers = new HttpHeaders();
        String tuid = authCaller.result().getResults().get(0).getData().getTuid();

        headers.add("Cookie", tuid);
        headers.add("content-type", "application/json");

        ResponseEntity<Element> response = restTemplate.postForEntity(requestParams.getUrl(), new HttpEntity<>(requestParams.getBody(), headers), Element.class);
        TransferTuidDto transferTuidDto = new TransferTuidDto();
        transferTuidDto.setTuid(tuid);
        transferTuidDto.setResponseElement(response.getBody());

        System.out.println(citilink.toCookie(transferTuidDto));
    }
}
