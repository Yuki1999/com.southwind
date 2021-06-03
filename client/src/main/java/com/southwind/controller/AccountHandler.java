package com.southwind.controller;


import com.southwind.entity.Admin;
import com.southwind.entity.User;
import com.southwind.feign.AccountFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username,password,type);
        LinkedHashMap<String,Object> hashMap = (LinkedHashMap) object;
        String result = null;
        String idStr = null;
        long id = 0L;
        if(object == null){
            result = "login";
        }else{
            switch (type){
                case "user":
                    User user = new User();
                    idStr = hashMap.get("id")+"";
                    id = Long.parseLong(idStr);
                    String nickname = (String)hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
//                    result = "redirect:/account/redirect/index";
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    idStr = hashMap.get("id")+"";
                    id = Long.parseLong(idStr);
                    String username2 = (String)hashMap.get("username");
                    admin.setId(id);
                    admin.setUsername(username2);
                    session.setAttribute("admin",admin);
                    //result = "redirect:/account/redirect/main";
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
//
//    @RequestMapping("/redirect/{target}")
//    public String redirect(@PathVariable("target") String target){
//        return target;
//    }
//
//    private User convertUser(Account account){
//        User user = new User();
//        user.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        user.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        user.setGender(ReflectUtils.getFieldValue(account,"gender")+"");
//        user.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        user.setNickname(ReflectUtils.getFieldValue(account,"nickname")+"");
//        user.setRegisterdate((Date)(ReflectUtils.getFieldValue(account,"registerdate")));
//        user.setTelephone(ReflectUtils.getFieldValue(account,"telephone")+"");
//        return user;
//    }
//
//    private Admin convertAdmin(Account account){
//        Admin admin = new Admin();
//        admin.setUsername(ReflectUtils.getFieldValue(account,"username")+"");
//        admin.setPassword(ReflectUtils.getFieldValue(account,"password")+"");
//        admin.setId((long)(ReflectUtils.getFieldValue(account,"id")));
//        return admin;
//    }
}

