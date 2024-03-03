package com.reader.read.utils;

import com.reader.read.dtos.citilink.Element;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GraphQLRequest {
    private final RestTemplate restTemplate = new RestTemplate();
    public void test(String tuid, String url) {
//        String graph = "https://www.citilink.ru/graphql/";
//        HttpHeaders headers = new HttpHeaders();
//
//        headers.add("Cookie", tuid + "; _space=srt_cl; _city_guessed=1; ab_test_segment=92");
//        headers.add("Origin", "https://www.citilink.ru");
//        headers.add("Referer", url);
//        headers.add("content-type", "application/json");
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
//
//        restTemplate.postForEntity(graph, requestEntity, Element.class);


        String body = "{\n" +
                "  \"filter1\": {\n" +
                "    \"id\": \"1993121\"\n" +
                "  },\n" +
                "  \"input2\": {\n" +
                "    \"pagination\": {\n" +
                "      \"page\": 1,\n" +
                "      \"perPage\": 4\n" +
                "    },\n" +
                "    \"forCurrentUser\": false\n" +
                "  },\n" +
                "  \"input3\": {\n" +
                "    \"pagination\": {\n" +
                "      \"page\": 1,\n" +
                "      \"perPage\": 1\n" +
                "    }\n" +
                "  }\n" +
                "}";

        String graph = "https://www.citilink.ru/graphql/";
        HttpHeaders headers = new HttpHeaders();

        headers.add("Cookie", tuid + "; _space=srt_cl; _city_guessed=1; ab_test_segment=92");
        headers.add("Origin", "https://www.citilink.ru");
        headers.add("Referer", url);
        headers.add("content-type", "application/json");

        restTemplate.postForEntity(graph,  new HttpEntity<>(body, headers), Element.class);
    }
}
