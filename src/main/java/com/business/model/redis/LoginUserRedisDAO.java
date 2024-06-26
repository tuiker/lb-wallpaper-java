package com.business.model.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.business.auth.entity.LoginUser;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * 登录用户缓存信息 DAO
 *
 * @Author yxf
 */

@Repository
public class LoginUserRedisDAO {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 登录用户token缓存 KEY
     * %s占位符为访问令牌 token
     */
    public static final String LOGIN_USER_TOKEN = "auth_token:%s";
    /**
     * 默认过期时间 24小时
     */
    public static final Long EX_TIME = 8640L;

    /**
     * 根据token获取redis中的用户信息
     * @param token 用户token
     * @return 用户信息
     */
    public LoginUser get(String token){
        String redisKey = formatKey(token);
        return JSONObject.parseObject(stringRedisTemplate.opsForValue().get(redisKey), LoginUser.class);
    }

    /**
     * 设置redis中token缓存
     * @param token token
     * @param loginUser 用户信息
     * @param isSys 是否系统用户，true：是，false：否；
     */
    public void set(String token, LoginUser loginUser, boolean isSys){
        String redisKey = formatKey(token);
        //如果非系统用户，则过期时间为30天
        long exTime = isSys ? EX_TIME : EX_TIME * 30;
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSONString(loginUser), exTime, TimeUnit.SECONDS);
    }

    /**
     * 移除token
     * @param token token
     */
    public void remove(String token){
        String redisKey = formatKey(token);
        stringRedisTemplate.delete(redisKey);
    }


    /**
     * 格式化缓存KEY
     * @param token 用户token
     * @return
     */
    private static String formatKey(String token) {
        return String.format(LOGIN_USER_TOKEN, token);
    }

}
