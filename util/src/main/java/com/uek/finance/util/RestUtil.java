package com.uek.finance.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * RestUtil工具类
 * @author RanJi
 */
public class RestUtil {
    private static Logger log = LoggerFactory.getLogger(RestUtil.class);

    public static String postJSON(RestTemplate restTemplate,String url, Object param){
        HttpEntity<String> httpEntity = makePostJsonEntiry(param);
        String result = restTemplate.postForObject(url,httpEntity,String.class);
        return result;
    }

    /**
     * 生成json格式的请求头
     * @param param
     * @return
     */
    private static HttpEntity<String> makePostJsonEntiry(Object param){
        //-- 请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept",MediaType.APPLICATION_JSON_VALUE);
        //-- 请求实体
        HttpEntity<String> httpEntity = new HttpEntity(JSON.toJSONString(param),headers);
        log.info("请求参数：{}",httpEntity.toString());
        return httpEntity;
    }

}
