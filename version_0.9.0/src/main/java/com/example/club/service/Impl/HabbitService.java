package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.HabbitDAO;
import com.example.club.dao.UserDao;
import com.example.club.service.IHabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class HabbitService  {

    @Autowired
    private HabbitDAO clbdao;
    @Autowired
    private UserDao userDao;
//    Random r=new Random();


    public JSONObject createHabbit(JSONObject inform, int UserId){
        //create a blank JSON
        JSONObject newhabbit = new JSONObject();
        //complete the JSON
        newhabbit.put("name", inform.getString("name"));
        newhabbit.put("info", inform.getString("inform"));
        Date date = new Date();
        newhabbit.put("date",date);
        String user = userDao.getusername(UserId);
        newhabbit.put("creator", UserId);
        newhabbit.put("image", inform.getString("profile"));
        //create a new habbit by using newhabbit(JSON), return state
        int statenow = clbdao.createhabbit(newhabbit);
        //state = 1, success; state = 0, 社团重名; state = 2, 创建超时
        if (statenow == 1){
            //社团创建成功也有可能访问超时，res的state=2
            JSONObject res = clbdao.getHabbitbyName(inform.getString("name"));
            return res;
        }
        else {
            //state= 0，社团重名；state=2，创建超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            res.put("habbitId", newhabbit.getInteger("id"));
            res.put("habbitName", newhabbit.getString("habbitName"));
            return res;
        }

    }


    public JSONObject modifyHabbit(JSONObject inform,int HabbitId,int UserId){
        //modify habbit(HabbitId), return state

        int statenow = clbdao.modifyhabbit(inform,HabbitId, UserId);
        //state = 1, 成功修改post；state = 0, 不合规范，修改失败；state = 2, 修改超时
        if (statenow == 1){
            //修改成功也可能访问超时
            JSONObject res = clbdao.getHabbitbyId(HabbitId);
            return res;
        }
        else{
            //state = 0, 不合规范，修改失败；state = 2, 修改超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            return res;
        }
    }


    public JSONObject viewHabbit(int HabbitId,int UserId){
        try{
            //use the HabbitDAO method view()
            JSONObject habbit = clbdao.getHabbitbyId(HabbitId);
            System.out.println(habbit);
            //create a new JSON
            JSONObject res = new JSONObject();
            //fill up JSON res
            res.put("name", habbit.getString("habbitName"));
            //Habbit doesn't have "category", default 艺术类
            res.put("category","艺术类");
            //Habbit doesn't have "fans number", default 100
            res.put("fans number",100);
            //Habbit doesn't have "pubications number", default 100
            res.put("publications number",100);
            //Habbit doesn't have "comment number", default 50
            res.put("comments number",50);
            //Habbit doesn't have "subscribe", default 156
            res.put("subscribe",156);

            res.put("inform", habbit.getString("habbitInfo"));
            res.put("profile", habbit.getString("image"));
            res.put("created time", habbit.getString("createDate"));
            res.put("creator", habbit.getString("creator"));
            res.put("res", habbit);

            return res;
        }
        catch (RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }


    public JSONObject viewHabbitbyAccount(int UserId){
        List<Object> list = clbdao.listmyhabbits(UserId);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject temp = clbdao.getHabbitbyId((Integer) list.get(i));
            res.put("habbit"+Integer.toString(i), temp);
        }
        return res;

    }

    public JSONObject viewAnnouncement(int UserId){
        /*return clbdao.viewannouncement(UserId);*/
        /*        因为数据库目前没有announcement存储，同时前端没有发布的位置，所以暂时静态*/
        JSONObject AnnouncementList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject Announcement=new JSONObject();
            Announcement.put("context","塔可夫斯基《乡愁》放映");
            AnnouncementList.put("announcement"+Integer.toString(i),Announcement);
        }
        return AnnouncementList;
    }



    public JSONObject viewAttensionList(int UserId){
        /*        目前前端没有做界面，所以可以先不实现*/
        /*        return clbdao.viewattensionlist(UserId);*/
        JSONObject res = new JSONObject();
        return res;
    }
}
