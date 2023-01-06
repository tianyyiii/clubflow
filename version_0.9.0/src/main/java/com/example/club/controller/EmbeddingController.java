package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/embedding")
public class EmbeddingController {
    private RestTemplate restTemplate=new RestTemplate();
    @GetMapping("/text_to_vector")
    public JSONObject texttoVector(@RequestBody JSONObject inform){
        String text=inform.getString("text");
        int PostId=inform.getInteger("postid");
        String url="http://localhost:5000/text_to_vector?text={text}&postid={postid}";
        Map<String,Object> params=new HashMap<>();
        params.put("text",text);
        params.put("postid",PostId);
        System.out.println(params);
        String result=restTemplate.getForObject(url,String.class,params);
        JSONObject res=new JSONObject();
        res.put("res",result);
        return res;

    }
    @GetMapping("/similar_post")
    public JSONObject similarPost(int PostId){
        String url="http://localhost:5000/similar_post?postid={postid}";
        Map<String,Object> params=new HashMap<>();
        params.put("postid",PostId);
        System.out.println(params);
        String res =restTemplate.getForObject(url,String.class,params);
        JSONObject result=new JSONObject();
        result.put("post",res);
        return result;
    }
}
