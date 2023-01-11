package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.SearchDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchService {
    @Autowired
    private SearchDAO searchDAO;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JSONObject searchforClub(JSONObject inform){
        String key=inform.getString("key");
        String sql="SELECT * from club where match(clubName,clubInfo) against(?)";
        key="%"+key+"%";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,key);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject club = new JSONObject(list.get(i));
            res.put("club"+Integer.toString(i),club);
        }
        return res;
    }

    public JSONObject searchforHabbit(JSONObject inform){
        String key=inform.getString("key");
        String sql="SELECT * from habbit where match(habbitName,habbitInfo) against(?)";
        key="%"+key+"%";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,key);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject club = new JSONObject(list.get(i));
            res.put("habbit"+Integer.toString(i),club);
        }
        return res;
    }

    public JSONObject searchforPost(JSONObject inform){
        String key=inform.getString("key");
        key="%"+key+"%";
        String sql="SELECT * from post where match(title,context) against(?)";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,key);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject club = new JSONObject(list.get(i));
            res.put("post"+Integer.toString(i),club);
        }
        return res;

    }

}
