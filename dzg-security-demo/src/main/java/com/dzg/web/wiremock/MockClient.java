package com.dzg.web.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @program: dzg-security
 * @description: wireMock客户端
 * @author: dzg
 * @create: 2019-02-09 17:01
 **/
public class MockClient {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor(8062);
        WireMock.removeAllMappings();
        mock("/order/1","1");
        mock("/order/2","2");

    }

    private static void mock(String url,String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/"+fileName+".txt");
        String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray());
        WireMock.stubFor(WireMock.get(WireMock.urlPathEqualTo(url)).willReturn(WireMock.aResponse()
                .withBody(content).withStatus(200)));
    }
}
