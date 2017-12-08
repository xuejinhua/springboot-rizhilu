package com.demo.controller;

import com.demo.result.ResultBody;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;

    /**
     * 微信登录
     * @param code 用户编码
     * @return ResultBody
     */
    @RequestMapping("/login")
    public ResultBody login(@RequestParam(value = "js_code",required = true) String code){
        return new ResultBody(userInfoService.login(code));
    }
}
