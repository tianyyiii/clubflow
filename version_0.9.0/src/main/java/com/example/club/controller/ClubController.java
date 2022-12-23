package com.example.club.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.club.service.IClubService;
import com.example.club.service.Impl.ClubService;
import com.example.club.utils.ImageUtil;
import io.swagger.annotations.Api;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
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
    private ClubService clubService;
   /* checked*/
    @PermitAll
    @PutMapping("/create")
    public JSONObject CreateClub(@RequestBody JSONObject inform,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("club id",800);
        return state;*/
        return clubService.createClub(inform,UserId);

    }
    /*checked*/
    @PostMapping("/modify")
    public JSONObject ModifyClub(@RequestBody JSONObject inform,int ClubId,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        return clubService.modifyClub(inform,ClubId,UserId);
    }
   /* checked*/
    @PermitAll
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
    /*checked*/
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
    @Deprecated
    @GetMapping("/announcement/view")
    /*this will be deprecated,the announcements can be found in ViewClubbyAccount*/
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
/*inform get context,which is string*/
    /*checked*/
    @PutMapping("/announcement/create")
    public JSONObject CreateAnnouncement(@RequestBody JSONObject inform,int ClubId,int UserId){
        return clubService.createAnnouncement(inform, ClubId, UserId);
    }
    /*checked*/
    @PostMapping("/announcement/modify")
    public JSONObject ModifyAnnouncement(@RequestBody JSONObject inform,int ClubId,int UserId){
        return clubService.modifyAnnouncement(inform, ClubId, UserId);
    }
    /*checked*/
    @DeleteMapping("/announcement/delete")
    public JSONObject DeleteAnnouncement(int ClubId,int UserId){
        return clubService.deleteAnnouncement(ClubId, UserId);
    }
    /*checked*/
    @PostMapping("/subscribe")
    public JSONObject Subscribe(int ClubId,int UserId){
        return clubService.subscribe(ClubId,UserId);
    }
    /*checked*/
    @PostMapping("/unsubscribe")
    public JSONObject Unsubscribe(int ClubId,int UserId){
        return clubService.unsubscribe(ClubId, UserId);
    }

/*
    @Autowired
    private ClubService clubservice;
*/





}
