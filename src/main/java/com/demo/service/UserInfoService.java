package com.demo.service;

import java.util.Map;

public interface UserInfoService {
    /**
     * 微信用户登录操作
     * @param code
     * @return
     */
    Map<String, Object> login(String code);
}
