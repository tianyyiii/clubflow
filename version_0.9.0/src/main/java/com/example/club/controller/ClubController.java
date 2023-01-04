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
    public JSONObject CreateClub(@RequestBody JSONObject inform){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("club id",800);
        return state;*/
//        需要：name inform profile UserId
        int UserId = inform.getIntValue("UserId");
        return clubService.createClub(inform,UserId);

    }

    @GetMapping("/get_created_club")
    // 查看社团用户创建的社团
    public JSONObject GetCreatedClub(int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("club id",800);
        return state;*/
//        state == 1 成功 ，state ==2 失败
        return clubService.getCreatedClub(UserId);

    }
    /*checked*/
    @PostMapping("/modify")
    public JSONObject ModifyClub(@RequestBody JSONObject inform){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        // ClubId UserId name inform image
        int ClubId = inform.getIntValue("ClubId");
        int UserId = inform.getIntValue("UserId");
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

//    查看某用户关注的社团
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

    @GetMapping("/view_all_clubs")
//    查看存在的所有社团列表
    public JSONObject ViewAllClubs(){
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
        return clubService.viewAllClubs();


    }

    @GetMapping("/view_fans")
//    查看某一社团的粉丝
    public JSONObject ViewClubFans(int ClubId){
/*        JSONObject FanList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject fan=new JSONObject();
            fan.put("image","url");
            fan.put("name","geyuan");
            fan.put("id",1);
        }
        return ClubList;*/
        return clubService.viewClubFans(ClubId);


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

    /*checked*/
    @PutMapping("/announcement/create")
    public JSONObject CreateAnnouncement(@RequestBody JSONObject inform){
        int ClubId = inform.getIntValue("ClubId");
        int UserId = inform.getIntValue("UserId");
//        传入"context" "ClubId" "UserId"
        return clubService.createAnnouncement(inform, ClubId, UserId);
    }
    /*checked*/
    @PostMapping("/announcement/modify")
    public JSONObject ModifyAnnouncement(@RequestBody JSONObject inform){
        int ClubId = inform.getIntValue("ClubId");
        int UserId = inform.getIntValue("UserId");
        return clubService.modifyAnnouncement(inform, ClubId, UserId);
    }
    /*checked*/
    @DeleteMapping("/announcement/delete")
    public JSONObject DeleteAnnouncement(int ClubId,int UserId){
        return clubService.deleteAnnouncement(ClubId, UserId);
    }
    /*checked*/
    @PostMapping("/subscribe")
    public JSONObject Subscribe(@RequestBody JSONObject inform){
        int ClubId = inform.getIntValue("ClubId");
        int UserId = inform.getIntValue("UserId");
        // state0 失败，state1 成功
        return clubService.subscribe(ClubId,UserId);
    }
    /*checked*/
    @PostMapping("/unsubscribe")
    public JSONObject Unsubscribe(@RequestBody JSONObject inform){
        int ClubId = inform.getIntValue("ClubId");
        int UserId = inform.getIntValue("UserId");
        // state0 失败，state1 成功
        return clubService.unsubscribe(ClubId, UserId);
    }

/*
    @Autowired
    private ClubService clubservice;
*/





}
