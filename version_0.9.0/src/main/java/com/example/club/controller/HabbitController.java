

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

    @PutMapping("/create")
    public JSONObject CreateHabbit(@RequestBody JSONObject inform,int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("habbit id",800);
        return state;*/
        return habbitService.createHabbit(inform,UserId);

    }

    @GetMapping("/get_created_habbit")
    // 查看普通用户创建的爱好社区
    public JSONObject GetCreatedHabbit(int UserId){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("club id",800);
        return state;*/
        return habbitService.getCreatedHabbit(UserId);

    }

    @PostMapping("/modify")
    public JSONObject ModifyHabbit(@RequestBody JSONObject inform){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        // HabbitId UserId name inform image
        int HabbitId = inform.getIntValue("HabbitId");
        int UserId = inform.getIntValue("UserId");
        return habbitService.modifyHabbit(inform,HabbitId,UserId);
    }

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

    @GetMapping("/view_by_account")
    // 关注的爱好社区
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
    @GetMapping("/view_all_habbits")
//    查看存在的所有社团列表
    public JSONObject ViewAllHabbits(){
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
        return habbitService.viewAllHabbits();


    }
    @GetMapping("/view_fans")
//    查看某一爱好的粉丝
    public JSONObject ViewClubFans(int HabbitId){
/*        JSONObject FanList=new JSONObject();
        for (int i=1;i<3;i++)
        {   JSONObject fan=new JSONObject();
            fan.put("image","url");
            fan.put("name","geyuan");
            fan.put("id",1);
        }
        return ClubList;*/
        return habbitService.viewHabbitFans(HabbitId);


    }
    @PostMapping("/subscribe")
    public JSONObject subscribe(@RequestBody JSONObject inform){
        int HabbitId = inform.getIntValue("HabbitId");
        int UserId = inform.getIntValue("UserId");
        // state0 失败，state1 成功
        return habbitService.subscribe(HabbitId,UserId);
    }

    @PostMapping("/unsubscribe")
    public JSONObject unsubscribe(@RequestBody JSONObject inform){
        int HabbitId = inform.getIntValue("HabbitId");
        int UserId = inform.getIntValue("UserId");
        // state0 失败，state1 成功
        return habbitService.unsubscribe(HabbitId,UserId);
    }

}