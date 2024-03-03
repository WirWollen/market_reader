package com.reader.read.utils;

import com.reader.read.builders.ItemBuilder;
import com.reader.read.dtos.OutputItemDto;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@EnableScheduling
public class TestComponent {
    private static final String span = "#__next > div > main > div.app-catalog-avk7an.ewgkexk0 > div.e19lhdq00.app-catalog-1sbr2xg.e164boj10 > div > div.app-catalog-1u5zjt4.e6riv00 > div > div.app-catalog-qhusmh.eme04gi0 > div:nth-child(4) > div.app-catalog-0.e33gsaq0 > div > div.app-catalog-0.e1xrzi9t0 > span > span > span.e1j9birj0.e106ikdt0.app-catalog-8hy98m.e1gjr6xo0";


    @SneakyThrows
    @Scheduled(fixedRate = 600)
    public void test() {
        Document document = Jsoup.connect("https://www.citilink.ru/product/monitor-huawei-34-zqe-caa-va-fhd-cher-hdmi-dp-usb-m-m-has-350cd-2004548/").get();

        Node h1 = document.select(span).get(0).childNode(0);

        OutputItemDto output = ItemBuilder.buildOutput(Long.valueOf(h1.toString().replaceAll("[^0-9]", "")), 1L, 1);

        System.out.println(output);
    }
}
