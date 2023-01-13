package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.ClubDAO;
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

    @Autowired
    private ClubDAO clbdao;

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
            JSONObject post = new JSONObject(list.get(i));
            JSONObject tmp = new JSONObject();
            tmp.put("title", post.getString("title"));
            tmp.put("context", post.getString("context"));
            tmp.put("thumbs-up num", post.getIntValue("thumbs"));
            tmp.put("comments num", 0);
            tmp.put("club name", clbdao.getClubbyId(post.getIntValue("club")).getString("clubName"));
            tmp.put("club profile", clbdao.getClubbyId(post.getIntValue("club")).getString("image"));
            tmp.put("image", post.getString("image"));
            tmp.put("club id", post.getIntValue("club"));
            tmp.put("date", post.getString("lastModifyDate"));
            tmp.put("postId",post.getString("postId"));
            res.put("post"+Integer.toString(i),tmp);
        }
        return res;

//        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql,key);
//        JSONObject res = new JSONObject();
//        for (int i=0; i<list.size(); i++){
//            JSONObject club = new JSONObject(list.get(i));
//            res.put("post"+Integer.toString(i),club);
//        }
//        return res;

    }

}
