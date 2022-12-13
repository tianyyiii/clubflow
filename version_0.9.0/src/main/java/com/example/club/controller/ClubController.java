package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.IClubService;
import com.example.club.utils.ImageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags="club api")
@RestController
@RequestMapping("/club")
public class ClubController {
    @Autowired
    private ImageUtil imageUtil;
    @Autowired
    private IClubService clubService;
    @PutMapping("/create")
    public JSONObject CreateClub(JSONObject inform,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("club id",800);
        return state;*/
        return clubService.createClub(inform,UserId);

    }
    @PostMapping("/modify")
    public JSONObject ModifyClub(JSONObject inform,int ClubId,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        return clubService.modifyClub(inform,ClubId,UserId);
    }
    @GetMapping("/view")
    public JSONObject ViewClubPage(int ClubId,int UserId){
/*        JSONObject club=new JSONObject();
        club.put("name","800号电影社");
        club.put("category","文化艺术类");
        club.put("fans number",10000);
        club.put("publications number",100);
        club.put("comments number",50);
        club.put("inform","这是一个电影社团");
        club.put("profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
        club.put("created time","2010-10-2");
        club.put("subscribe",1);
        return club;*/
        return clubService.viewClub(ClubId,UserId);
    }
    @GetMapping("/view_by_account")
    public JSONObject ViewClubbyAccount(int UserId){
/*        JSONObject ClubList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject club=new JSONObject();
            club.put("name","800号电影社");
            club.put("category","文化艺术类");
            club.put("fans number",10000);
            club.put("publications number",100);
            club.put("comments number",50);
            club.put("inform","这是一个电影社团");
            club.put("profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\club_project\\image\\tarkovsky.png"));
            club.put("created time","2010-10-2");
            club.put("subscribe",1);
            ClubList.put("club"+Integer.toString(i),club);
        }
        return ClubList;*/
        return clubService.viewClubbyAccount(UserId);


    }
    @GetMapping("/view_announcement")
    public JSONObject ViewAnnouncement(int UserId) {
/*        JSONObject AnnouncementList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject Announcement=new JSONObject();
            Announcement.put("context","塔可夫斯基《乡愁》放映");
            AnnouncementList.put("announcement"+Integer.toString(i),Announcement);
        }
        return AnnouncementList;


    }*/
        return clubService.viewAnnouncement(UserId);
    }

/*
    @Autowired
    private ClubService clubservice;
*/





}
