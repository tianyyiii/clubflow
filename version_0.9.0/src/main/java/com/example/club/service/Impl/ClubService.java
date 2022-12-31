package com.example.club.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.example.club.dao.ClubDAO;
import com.example.club.dao.UserDao;
import com.example.club.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClubService implements IClubService {

    @Autowired
    private ClubDAO clbdao;
    @Autowired
    private UserDao userDao;

    @Override
    public JSONObject createClub(JSONObject inform, int UserId){
        //create a blank JSON
        JSONObject newclub = new JSONObject();
        //complete the JSON
        newclub.put("name", inform.getString("name"));
        newclub.put("info", inform.getString("inform"));
        Date date = new Date();
        newclub.put("date",date);
        newclub.put("publications",0);
        newclub.put("fans",0);
        newclub.put("comments",0);
        newclub.put("creator", UserId);
        newclub.put("image", inform.getString("profile"));
        //create a new club by using newclub(JSON), return state
        int statenow = clbdao.createclub(newclub);
        //state = 1, success; state = 0, 社团重名; state = 2, 创建超时
        if (statenow == 1){
            //社团创建成功也有可能访问超时，res的state=2
            JSONObject res = clbdao.getClubbyName(inform.getString("name"));
            return res;
        }
        else {
            //state= 0，社团重名；state=2，创建超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            res.put("clubId", newclub.getInteger("id"));
            res.put("clubName", newclub.getString("clubName"));
            return res;
        }

    }

    @Override
    public  JSONObject getCreatedClub(int UserId){
        JSONObject res = clbdao.getClubbyCreatorId(UserId);
        return res;
    }

    @Override
    public JSONObject modifyClub(JSONObject inform,int ClubId,int UserId){
        //modify club(ClubId), return state

        int statenow = clbdao.modifyclub(inform,ClubId, UserId);
        //state = 1, 成功修改post；state = 0, 不合规范，修改失败；state = 2, 修改超时
        if (statenow == 1){
            //修改成功也可能访问超时
            JSONObject res = clbdao.getClubbyId(ClubId);
            return res;
        }
        else{
            //state = 0, 不合规范，修改失败；state = 2, 修改超时
            JSONObject res = new JSONObject();
            res.put("state", statenow);
            return res;
        }
    }

    @Override
    public JSONObject viewClub(int ClubId,int UserId){
        try{
            //use the ClubDAO method view()
            JSONObject club = clbdao.getClubbyId(ClubId);
            //create a new JSON
            JSONObject res = new JSONObject();
            //fill up JSON res
            res.put("name", club.getString("clubName"));
            //Club doesn't have "category", default 艺术类
            res.put("category","艺术类 this will be deprecated");
            //Club doesn't have "fans number", default 100
            res.put("fans number",club.getInteger("fansNum"));
            //Club doesn't have "pubications number", default 100
            res.put("publications number",club.getInteger("publicationsNum"));
            //Club doesn't have "comment number", default 50
            res.put("comments number",club.getInteger("commentsNum"));
            //subscribe指用户有没有订阅
            int subscribe = clbdao.checkSubscribebyUser(ClubId,UserId) == 1? 1:0;
            res.put("subscribe",subscribe);

            //Club announcement
            res.put("announcement",club.getString("announcement"));

            res.put("inform", club.getString("clubInfo"));
            res.put("profile", club.getString("image"));
            res.put("created time", club.getString("createDate"));
            res.put("creator", club.getString("creator"));
            res.put("state",1);
            return res;
        }
        catch (RuntimeException e){
            JSONObject res = new JSONObject();
            res.put("state", 2);
            return res;
        }
    }

    @Override
    public JSONObject viewClubbyAccount(int UserId){
        List<Object> list = clbdao.listmyclubs(UserId);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject temp = clbdao.getClubbyId((Integer) list.get(i));
            res.put("club"+Integer.toString(i), temp);
        }
        return res;

    }

    @Override
    public JSONObject viewAllClubs(){
        List<Object> list = clbdao.listallclubs();
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject temp = clbdao.getClubbyId((Integer) list.get(i));
            res.put("club"+Integer.toString(i), temp);
        }
        return res;

    }

    @Override
    public JSONObject viewClubFans(int ClubId){
        List<Object> list = clbdao.listclubfans(ClubId);
        JSONObject res = new JSONObject();
        for (int i=0; i<list.size(); i++){
            JSONObject temp = userDao.getUserbyId((Integer) list.get(i));
            res.put("fan"+Integer.toString(i), temp);
//            System.out.println(temp);
        }
        return res;
    }

    @Override
    public JSONObject viewAnnouncement(int UserId){
        JSONObject res=new JSONObject();
        return res;
    }

    public JSONObject subscribe(Integer ClubId,Integer UserId){
        JSONObject res=new JSONObject();
        if (clbdao.checkSubscribebyUser(ClubId,UserId)==1){
            res.put("state",0);
            res.put("error","already subscribed");
            return res;
        }
        else{
            JSONObject inform=clbdao.getClubbyId(ClubId);
            int fans= (int) inform.get("fansNum");
            fans=fans+1;
            int state= clbdao.subscribeAdd(ClubId,fans);
            JSONObject temp=new JSONObject();
            Date date=new Date();
            temp.put("clubid",ClubId);
            temp.put("fanid",UserId);
            temp.put("state",1);
            temp.put("date",date);
            clbdao.createSubscribe(temp);
            res.put("state",1);
            return res;}

    }

    public JSONObject unsubscribe(Integer ClubId,Integer UserId){
        JSONObject res=new JSONObject();
        if (clbdao.checkSubscribebyUser(ClubId,UserId)==2){
            res.put("state",0);
            res.put("error","not subscribed");
            return res;
        }
        else{
            JSONObject inform=clbdao.getClubbyId(ClubId);
            int fansNum= (int) inform.get("fansNum");
            fansNum=fansNum-1;
            int state= clbdao.subscribeMinus(ClubId,fansNum);
            clbdao.deleteSubscribe(ClubId,UserId);
            res.put("state",1);
            return res;}
    }

    public JSONObject createAnnouncement(JSONObject inform,int ClubId,int UserId){
        int state= clbdao.editAnnouncementbyClubId(inform.getString("context"),ClubId);
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;


    }

    public JSONObject modifyAnnouncement(JSONObject inform,int ClubId,int UserId){
        int state= clbdao.editAnnouncementbyClubId(inform.getString("context"),ClubId);
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;


    }

    public JSONObject deleteAnnouncement(int ClubId,int UserId){
        int state= clbdao.editAnnouncementbyClubId(null,ClubId);
        JSONObject res=new JSONObject();
        res.put("state",state);
        return res;
}}