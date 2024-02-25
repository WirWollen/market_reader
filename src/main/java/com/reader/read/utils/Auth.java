package com.reader.read.utils;

import com.reader.read.dtos.ctl.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class Auth {
    public GlobalSendDataDto generateGlobalSendDataDto(String url, String tuid1, String tuid2, String tuid3) {
        var response = new GlobalSendDataDto();

        var command1 = new CommandsDto();
        command1.setName("system/ids");
        var data1 = new DataDto();
        data1.setProject_id(tuid1);
        data1.setCookie(tuid2);
        var customer = new CustomerDto();
        customer.setTuid(tuid3);
        data1.setCustomer(customer);
        data1.setExpires(1803469953L);
        command1.setData(data1);

        var command2 = new CommandsDto();
        command2.setName("system/push-notifications-vapid-key");
        var data2 = new DataDto();
        data2.setCompany_id(tuid1);
        command2.setData(data2);

        var command3 = new CommandsDto();
        command3.setName("crm/events");
        var data3 = new DataDto();
        var customerIds = new CustomerIdsDto();
        customerIds.setTuid(tuid3);
        customerIds.setCookie(tuid2);
        data3.setCustomer_ids(customerIds);
        data3.setCompany_id(tuid1);
        data3.setType("session_ping");
        data3.setAge(0.18899989128112793);
        var properties = new PropertiesDto();
        properties.setLocation("https://www.citilink.ru" + url + "?_action=autologin&_success_login=1");
        properties.setOs("Windows");
        properties.setBrowser("Chrome");
        properties.setDevice("Other");
        properties.setReferrer("");
        properties.setPath(url);
        properties.setActivity("page_load");
        properties.setCookie(tuid2);

        data3.setProperties(properties);
        data3.setTimestamp(BigDecimal.valueOf(1708861951.3737085));
        command3.setData(data3);

        response.setSdk("js-client");
        response.setSdk_version("v3.18.0");
        response.setSdk_snippet_version("v2.3.0");
        response.setCommands(List.of(command1, command2, command3));

        return response;
    }
}
