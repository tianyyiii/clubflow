package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Api(tags="用户信息")
@RestController
@Validated
@RequestMapping("/user")
public class UserController {
/*    @GetMapping("/view")
    public JSONObject viewUser(int UserIdtoView,int UserId){
        JSONObject user=new JSONObject();
        user.put("name","tarkovsky");
        user.put("profile",);
        user.put("inform","一个用户");
        user.put("")
    }*/

    @PutMapping("/create")
    public JSONObject createUser(@RequestBody JSONObject inform){
        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("UserId",10);

        return state;



    }
    @PostMapping("/modify/{UserId}")
    public JSONObject modifyUser(@RequestBody JSONObject inform, @Max(value=10,message="not more than 10") @PathVariable("UserId")int UserId){
        JSONObject state=new JSONObject();
        state.put("state",UserId);
        return state;
    }
    @DeleteMapping("/delete")
    public JSONObject deleteUser(int UserIdtoModify,int UserId){
        JSONObject state=new JSONObject();
        state.put("state",1);
        return state;
    }
    @GetMapping("/view")
    public JSONObject viewUser(int UserIdtoView,int UserId){
        JSONObject user=new JSONObject();
        return user;
    }
    public JSONObject checkUser(String UserName,String password){
        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("UserId",5);
        return state;
    }
}
