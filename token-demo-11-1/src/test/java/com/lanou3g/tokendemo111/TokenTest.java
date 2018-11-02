package com.lanou3g.tokendemo111;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lanou3g.tokendemo111.utils.JwtUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author 铭
 * 2018/11/1 10:44
 */
public class TokenTest {

    // 自定义密钥,可以自己随便写,越复杂越好
    public static final String SECRET_KEY = "53g2jkj2be215k1b1";

    @Test
    public void createToken() {
        // 创建token
        String token = JWT.create()
                // 在负载中添加自定义的数据
                .withClaim("userId", 1001)
                .withClaim("username", "admin")
                // 发布时间,也就是生成时间,可以稍微记录一下上次的登录时间
                .withIssuedAt(new Date())
                // 设置该token的过期时间
                // 10秒钟后该token过期
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000000))
                // sign要在最后调用,使用Algorithm选择加密方式,常用HMAC256
                .sign(Algorithm.HMAC256(SECRET_KEY));
        System.out.println(token);
        // 生成后的token: eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDEwNDEzNDksInVzZXJJZCI6MTAwMSwiaWF0IjoxNTQxMDQxMzM5LCJ1c2VybmFtZSI6Imt0bG42NjYifQ.tU_kElllOPZq4A67VEJCODlwD3OFi6ntC4V8ARO60Q0
    }

    @Test
    public void require() {
        // 根据校验规则HMAC256生成校验对象
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
        try {
            // 校验前端发送过来的token是否合法
            // 如果合法会返回一个解码后的jwt对象
            // 如果不合法,会抛出xxx异常
            // verify参数填写上面方法生成的token
            DecodedJWT jwt = verifier.verify("eyJ0e313XAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1NDEwNzQxOTcsInVzZXJJZCI6MTAwMSwiaWF0IjoxNTQxMDczMTk3LCJ1c2VybmFtZSI6ImFkbWluIn0.kp9lMYril6HPyE6r-Ro8guNoaEsmMfZIIFh5Om05kpM");
            System.out.println(jwt.getToken());
        } catch (TokenExpiredException e) {
            System.out.println("Token已经过期");
        } catch (SignatureVerificationException e) {
            System.out.println("Token不合法");
        } catch (Exception e) {
            System.out.println("认证失败");
        }
    }


    // token到期时间高于80%,就返回给他一个新的token,并做校验
    @Test
    public void json() throws InterruptedException {
        String token = JwtUtils.newToken(1001L, 10);
        System.out.println(token);
        Thread.sleep(8000);
        String newToken = JwtUtils.autoRequire(token);
        System.out.println(newToken);
    }

}
