package com.example.club.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.club.service.Impl.UserService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Api(tags="用户信息")
@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
/*    @GetMapping("/view")
    public JSONObject viewUser(int UserIdtoView,int UserId){
        JSONObject user=new JSONObject();
        user.put("name","tarkovsky");
        user.put("profile",);
        user.put("inform","一个用户");
        user.put("")
    }*/

    @PutMapping("/create")
    public JSONObject Register(@RequestBody JSONObject inform){
/*
        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("UserId",10);

        return state;
*/
        return userService.createUser(inform);



    }
    @PostMapping("/modify/{UserId}")
    public JSONObject ModifyUser(@RequestBody JSONObject inform, @Max(value=10,message="not more than 10") @PathVariable("UserId")int UserId){
        JSONObject state=new JSONObject();
        state.put("state",UserId);
        return state;
    }
    @DeleteMapping("/delete")
    public JSONObject DeleteUser(int UserIdtoDelete,int UserId){
   /*     JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        return userService.deleteUser(UserIdtoDelete);
    }
    @GetMapping("/view")
    public JSONObject ViewUser(int UserIdtoView,int UserId){/*
        JSONObject user=new JSONObject();
        return user;*/
        return userService.viewUser(UserIdtoView);
    }
    public JSONObject CheckUser(String UserName,String password){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("UserId",5);
        return state;*/
        return userService.checkUser(UserName,password);
    }
}
