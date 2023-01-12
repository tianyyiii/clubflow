package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/generation")
public class GenerationController {
    private RestTemplate restTemplate=new RestTemplate();
    @GetMapping("/text_to_image")
    public JSONObject texttoImage(String text){
        String url="http://localhost:5000/text_to_image?text={text}";
        Map<String,String> params=new HashMap<>();
        params.put("text",text);
        System.out.println(text);
        String location=restTemplate.getForObject(url,String.class,params);
        JSONObject res=new JSONObject();
        String imgURL = "http://localhost:8080/file/" + location;
        res.put("image",imgURL);
        return res;

    }

}
