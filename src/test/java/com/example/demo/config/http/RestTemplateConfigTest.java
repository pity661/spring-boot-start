package com.example.demo.config.http;

import static org.junit.Assert.*;

import com.example.demo.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfigTest extends BaseTest {

  @Autowired private RestTemplate restTemplate;

  @Test
  public void batchTest() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    map.add("batchNo", "114");
    HttpEntity entity = new HttpEntity(map, headers);
    int code =
        restTemplate
            .postForEntity("http://127.0.0.1:8100/httpService/endPushOverdue", entity, int.class)
            .getStatusCodeValue();
    System.out.println(code);
  }
}
