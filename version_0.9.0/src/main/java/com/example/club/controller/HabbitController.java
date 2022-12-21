

package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.IClubService;
import com.example.club.service.IHabbitService;
import com.example.club.service.Impl.HabbitService;
import com.example.club.utils.ImageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Api(tags="habbit api")
@RestController
@RequestMapping("/habbit")
public class HabbitController {
    @Autowired
    private ImageUtil imageUtil;
    @Autowired
    private HabbitService habbitService;
    /*除头像外可以正常完成*/
    @PutMapping("/create")
    public JSONObject CreateHabbit(@RequestBody JSONObject inform,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("habbit id",800);
        return state;*/
        return habbitService.createHabbit(inform,UserId);

    }
    /*除头像外可以正常完成*/
    @PostMapping("/modify")
    public JSONObject ModifyHabbit(@RequestBody JSONObject inform,int HabbitId,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        return habbitService.modifyHabbit(inform,HabbitId,UserId);
    }
    /*可以完成，但res外一些是静态的*/
    @GetMapping("/view")
    public JSONObject ViewHabbitPage(int HabbitId,int UserId){
/*        JSONObject habbit=new JSONObject();
        habbit.put("name","800号电影社");
        habbit.put("category","文化艺术类");
        habbit.put("fans number",10000);
        habbit.put("publications number",100);
        habbit.put("comments number",50);
        habbit.put("inform","这是一个电影社团");
        habbit.put("profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\habbit_project\\image\\tarkovsky.png"));
        habbit.put("created time","2010-10-2");
        habbit.put("subscribe",1);
        return habbit;*/
        return habbitService.viewHabbit(HabbitId,UserId);
    }
    /*基本功能可以完成，问题同上*/
    @GetMapping("/view_by_account")
    public JSONObject ViewHabbitbyAccount(int UserId){
/*        JSONObject HabbitList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject habbit=new JSONObject();
            habbit.put("name","800号电影社");
            habbit.put("category","文化艺术类");
            habbit.put("fans number",10000);
            habbit.put("publications number",100);
            habbit.put("comments number",50);
            habbit.put("inform","这是一个电影社团");
            habbit.put("profile",imageUtil.ImageToBase64("C:\\Users\\26010\\Downloads\\habbit_project\\image\\tarkovsky.png"));
            habbit.put("created time","2010-10-2");
            habbit.put("subscribe",1);
            HabbitList.put("habbit"+Integer.toString(i),habbit);
        }
        return HabbitList;*/
        return habbitService.viewHabbitbyAccount(UserId);


    }
/*    @GetMapping("/view_announcement")
    public JSONObject ViewAnnouncement(int UserId) {
*//*        JSONObject AnnouncementList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject Announcement=new JSONObject();
            Announcement.put("context","塔可夫斯基《乡愁》放映");
            AnnouncementList.put("announcement"+Integer.toString(i),Announcement);
        }
        return AnnouncementList;


    }*//*
        return habbitService.viewAnnouncement(UserId);
    }*/

/*
    @Autowired
    private HabbitService habbitservice;
*/





}