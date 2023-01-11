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
    @PostMapping("/club")
    public JSONObject SearchforClub(@RequestBody JSONObject inform){
        return searchService.searchforClub(inform);
    }

    @PostMapping("/habbit")
    public JSONObject SearchforHabbit(@RequestBody JSONObject inform){
        return searchService.searchforHabbit(inform);
    }

    @PostMapping("/post")
    public JSONObject SearchforPost(@RequestBody JSONObject inform){
        return searchService.searchforPost(inform);
    }



}
