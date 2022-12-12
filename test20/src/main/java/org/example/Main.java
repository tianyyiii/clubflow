package org.example;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Object> data =new HashMap<>();
        data.put("data",1);
        JSONObject json=new JSONObject(data);


        System.out.println(json);
    }
}