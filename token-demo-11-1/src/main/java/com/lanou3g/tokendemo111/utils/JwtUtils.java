package com.lanou3g.tokendemo111.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;

/**
 * @author 铭
 * 2018/11/1 11:41
 */
public class JwtUtils {

    /**
     * 默认过期时间30分钟
     *
     * @param userId 用户ID
     * @return token
     */
    public static String newToken(Long userId) {
        // 为一个用户设置token并设置默认到期时间
        return newToken(userId, Constants.DEFAULT_EXPIRED_SECONDS);
    }

    /**
     * @param userId         用户ID
     * @param expiredSeconds 过期时长
     * @return token
     */
    public static String newToken(Long userId, long expiredSeconds) {
        return JWT.create()
                .withClaim("userId", userId)
                // 发布时间
                .withIssuedAt(new Date())
                // 到期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + expiredSeconds * 1000))
                // 选择加密方式
                .sign(Algorithm.HMAC256(Constants.SECRET_KEY));
    }

    /**
     * 校验token是否合法
     *
     * @param token 需要校验的token
     * @return 是否合法
     */
    public static boolean checkToken(String token) {
        // 根据校验规则HMAC256生成校验对象
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(Constants.SECRET_KEY)).build();
        try {
            // 校验token是否合法
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 刷新token
     *
     * @param token 原token
     * @return 新token
     */
    public static String refreshToken(String token) {
        // 进行Base64解码
        DecodedJWT jwt = JWT.decode(token);
        // 获得解码后token里的负载中的用户ID
        Long userId = jwt.getClaim("userId").asLong();
        // 调用上面的创建token的方法创建新的token
        return newToken(userId);
    }

    /**
     * token到期时间高于80%,就返回给他一个新的token,并做校验
     * @param token
     * @return
     */
    public static String autoRequire(String token) {
        // 校验token
        boolean check = checkToken(token);
        if (check) {
            // 解码
            DecodedJWT jwt = JWT.decode(token);
            // 计算时间是否超过80%
            long current = System.currentTimeMillis() / 1000;
            // 获取开始时间
            Long start = jwt.getClaim("iat").asLong();
            // 获取结束时间
            Long end = jwt.getClaim("exp").asLong();
            if ((current - start) * 1.0 / (end - start) > 0.8) {
                // 时间超过80%返回新的token
                return refreshToken(token);
            } else {
                // 返回原来的token
                return token;
            }
        } else {
            throw new JWTVerificationException("token不合法");
        }
    }

}
