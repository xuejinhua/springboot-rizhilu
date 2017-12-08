package com.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.entity.UserInfo;
import com.demo.repository.UserInfoRepository;
import com.demo.service.UserInfoService;
import com.demo.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    /**
     * appid 小程序id
     * 微信公众平台 设置中的开发设置中可以查到，相当于qq的qq号
     * 建议单独创建一个配置文件储存此类值和函数
     */
    private static final String APP_ID = "wx0262c100d96ed074";
    /**
     * AppSecret 小程序密钥
     * 微信公众平台 设置中的开发设置中可以查询 但是每次查询会重置密钥 相当于qq的qq密码
     * 建议单独储存
     */
    private static final String SECRET = "940d22a4afdf6dc0c211fa4cc81bdea6";
    /**
     * 用于获取用户openid的接口网址
     * 其中%s将会用String.format函数替换为实际的值
     * 建议单独储存
     */
    private static final String WEB_ACCESS_TOKEN_HTTPS = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";

    @Autowired
    private UserInfoRepository userInfoRepository;
    /**
     * 用户登录
     */
    @Transactional
    @Override
    public Map<String, Object> login(String code) {
        Map<String, Object> map = new HashMap<>(1);
        String token = String.format(WEB_ACCESS_TOKEN_HTTPS, APP_ID, SECRET, code);
        String rec = HttpClientUtil.httpGetRequest(token);
        JSONObject json = JSON.parseObject(rec);
        if (json != null) {
            //获取openid
            String openid = json.getString("openid");
            UserInfo userInfo = userInfoRepository.findByOpenIdLike(openid);
            if (userInfo == null) {
                userInfo = new UserInfo();
                userInfo.setOpenId(openid);
                userInfo.setSessionKey(json.getString("session_key"));
                UserInfo result = userInfoRepository.save(userInfo);
                map.put("userId", result.getId());
            } else {
                map.put("userId", userInfo.getId());
            }
        }
        return map;
    }

}
