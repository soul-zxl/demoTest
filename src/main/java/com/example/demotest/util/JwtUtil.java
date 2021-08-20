package com.example.demotest.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demotest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//JWT 工具类
//工具类中包含：创建 token，验证 token，获取用户 id 等
public class JwtUtil {
    /*
     * 密钥
     * */
    private static final String SECRET = "123123";


    /*
     * 过期时间 单位(秒)
     * */

    private static final long EXPIRATION = 3600L;


    //生成一个token
    public static String createToken(User user) {
        HashMap<String, Object> map = new HashMap<>();
        //声明加密算法
        map.put("alg", "HS512");
        //声明类型
        //map.put("tye", "JWT");
        //创建一个token
        String token = JWT.create()
                //放入头部信息
                .withHeader(map)
                ////设置 载荷 签名是有谁生成 例如 服务器
                .withIssuer("SERVICE")
                ///设置 载荷 签名的主题
                .withSubject("这是一个登录请求")
                //设置 载荷 签名的观众 也可以理解谁接受签名的
                .withAudience("用户")
                // 可以将基本信息放到claims中
                .withClaim("id",user.getId())
                .withClaim("username", user.getName())
                // 超时设置,设置过期的日期
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                // 签发时间
                .withIssuedAt(new Date())
                // SECRET加密
                .sign(Algorithm.HMAC256(SECRET));
        System.out.println(token);
        return token;
    }


    //解析token




    @Test
    public static void verifyToken(String token) {

        //获取token
        //String token = createToken(user);
        //构建密钥信息
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        //通过密钥信息和签名的发布者的信息生成JWTVerifier (JWT验证类)
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("SERVICE")
                .build();
        DecodedJWT jwt = verifier.verify(token);

        //签名的主题
        String subject = jwt.getSubject();
        //签名的观众 也可以理解谁接受签名的
        List<String> audience = jwt.getAudience();
        //获取基本信息
        Map<String, Claim> claims = jwt.getClaims();
        //获取claims中的内容
        //用户名
        Claim username = jwt.getClaim("username");
        //Claim username = claims.get("username");
        System.out.println("username是：" + username);
        //密码
        Claim password = claims.get("password");
        System.out.println("password是：" + password);
        //获取主题
        System.out.println(subject);
        //签名主题
        System.out.println(audience.get(0));
        //谁签发
        String issuer = jwt.getIssuer();
        System.out.println(issuer);
    }


}

//public static Integer getUserid(){
//    //HttpServletRequest 请求对象
//    HttpServletRequest httpServletRequest = SpringContextUtils.getHttpServletRequest();
//    //从头部信息获取token,
//    // 根据 key（Authorization）获取 value 值
//    String token = httpServletRequest.getHeader("Authorization");
//
//    Algorithm algorithm = Algorithm.HMAC256(SECRET);
//    JWTVerifier verifier  = JWT.require(algorithm).build();
//    DecodedJWT jwt = verifier.verify(token);
//    if (null != jwt) {
//    //    拿到我们放置在token的信息
//        List<String> audience = jwt.getAudience();
//        if(CollectionUtil.isNotEmpty(audience)){
//
//        }
//
//    }
//
//
//    return 1;
//}

