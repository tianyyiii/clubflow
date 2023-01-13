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

@CrossOrigin
@Api(tags="用户信息")
@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

/*checked*/
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
    /*checked*/
    @PostMapping("/modify/{UserId}")
    public JSONObject ModifyUser(@RequestBody JSONObject inform, @Max(value=1000,message="not more than 10") @PathVariable("UserId")int UserId){

        System.out.println(inform);
        System.out.println(UserId);
        // name password profile
        return userService.modifyUser(inform,UserId);
    }
    /*checked*/
    @DeleteMapping("/delete")
    public JSONObject DeleteUser(int UserIdtoDelete,int UserId){
   /*     JSONObject state=new JSONObject();
        state.put("state",1);
        return state;*/
        return userService.deleteUser(UserIdtoDelete);
    }
    /*checked*/
    @GetMapping("/view")
    public JSONObject ViewUser(int UserIdtoView,int UserId){/*
        JSONObject user=new JSONObject();
        return user;*/
        return userService.viewUser(UserIdtoView);
    }
    /*checked*/
    @GetMapping("/check")
    public JSONObject CheckUser(String UserName,String Password){
/*        JSONObject state=new JSONObject();
        state.put("state",1);
        state.put("UserId",5);
        return state;*/
        return userService.checkUser(UserName,Password);
    }
}
