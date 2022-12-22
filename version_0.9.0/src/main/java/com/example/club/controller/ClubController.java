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

        return clubService.viewClub(ClubId,UserId);
    }
    @GetMapping("/view_by_account")
    public JSONObject ViewClubbyAccount(int UserId){

        return clubService.viewClubbyAccount(UserId);


    }
    @GetMapping("/view_announcement")
    public JSONObject ViewAnnouncement(int UserId) {

        return clubService.viewAnnouncement(UserId);
    }

}
