package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @GetMapping("/club")
    public JSONObject SearchforClub(@RequestBody JSONObject inform){
        return searchService.searchforClub(inform);
    }

    @GetMapping("/habbit")
    public JSONObject SearchforHabbit(@RequestBody JSONObject inform){
        return searchService.searchforHabbit(inform);
    }

    @GetMapping("/post")
    public JSONObject SearchforPost(@RequestBody JSONObject inform){
        return searchService.searchforPost(inform);
    }



}
