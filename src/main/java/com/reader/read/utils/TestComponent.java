package com.reader.read.utils;

import com.reader.read.builders.ItemBuilder;
import com.reader.read.config.RedisEntryBean;
import com.reader.read.dtos.OutputItemDto;
import com.reader.read.dtos.redis.OuterDto;
import com.reader.read.services.SenderService;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@EnableScheduling
public class TestComponent {
    @Autowired
    private RedisEntryBean entryBean;

    @Autowired
    private SenderService senderService;

    private Map<Long, OuterDto> citilinkItems;

    @Value("${span}")
    private String span;


    @SneakyThrows
    @Scheduled(fixedRate = 600)
    public void test() {
        citilinkItems = entryBean.getCitilinkItems();
        citilinkItems.keySet().forEach(el -> buildItem(citilinkItems.get(el)));
    }

    @SneakyThrows
    private void buildItem(OuterDto dto) {
        Node h1 = Jsoup.connect(dto.getUrl()).get().select(span).get(0).childNode(0);
        OutputItemDto output = ItemBuilder.buildOutput(Long.valueOf(h1.toString().replaceAll("[^0-9]", "")), dto.getId());
        senderService.send(output);
    }
}
