package com.reader.read.utils;

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
    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 600)
    public void test() {
//        String cookie = "_tuid=f4760a74769e3a938ac4e59a47ad177de100dffd; _space=srt_cl; _city_guessed=1; ab_test_segment=79; _sp_ses.faaa=*; flocktory-uuid=033f72b7-32b8-43c6-8c31-2273f8499c68-1; __exponea_etc__=e2447fb1-efe5-4b4b-83cd-f5aebaa6789a; __exponea_time2__=-1.5137557983398438; tmr_lvid=70d189c4cbff8315a3a32d730a8e9135; tmr_lvidTS=1704626867435; _ym_uid=1704626868307496128; _ym_d=1704626868; advcake_track_id=3f7e6864-600a-cc86-b56c-7ebaf2b253d2; advcake_session_id=fe93d89c-bace-9544-e14d-e4866af9a517; _ym_isad=2; gnezdo_uid=18ce3adcd9eb49a5f879fea7; AMP_TOKEN=%24NOT_FOUND; _gid=GA1.2.1182213192.1704626868; _dc_gtm_UA-5582449-1=1; adrdel=1; adrcid=AU5ICrCpdlWlWts_e2FOwhg; _gpVisits={\"isFirstVisitDomain\":true,\"idContainer\":\"100025C7\"}; _ga=GA1.1.833247690.1704626867; _sp_id.faaa=fbb65ab7-e85e-42ca-bb64-17760d1e4ee4.1704626867.1.1704626869..a53b6510-9c0a-482d-b282-1d9a14714d47..40f0660c-85df-4997-92f3-ca164a8f712d.1704626867369.4; _gp100025C7={\"hits\":2,\"vc\":1,\"ac\":1,\"a6\":1}; _spx=eyJpZCI6IjRkMGU3YjlmLTI1NjgtNGY0OS05MTI4LWUwZTVjNzcwZjMxMCIsInNvdXJjZSI6IiIsImZpeGVkIjp7InN0YWNrIjpbMCwwXX0sImZlZWQiOnsic3RhY2siOlsxNDQ5NzcyMDU5LDE0NDk3NzIwNTldfX0%3D; tmr_detect=0%7C1704626871793; _ga_DDRSRL2E1B=GS1.1.1704626866.1.1.1704626872.54.0.0; _ga_DDRSRL2E1B-DG=GS1.1.1704626866.1.1.1704626872.0.0.0";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", cookieGenerator.generateCookie());
        headers.add("content-type", "application/json");

        ResponseEntity<Element> response = restTemplate.postForEntity(requestParams.getUrl(), new HttpEntity<>(requestParams.getBody(), headers), Element.class);
        System.out.println(response);
    }
}
