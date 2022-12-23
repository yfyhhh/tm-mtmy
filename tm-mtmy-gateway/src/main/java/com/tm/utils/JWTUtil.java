package com.tm.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * token工具类
 */
public class JWTUtil {

    public static final String secret = "123!@#456$%^";

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        return parseToken(token,secret);
    }

    /**
     * 生成token
     * @param userId
     * @param phoneNum
     * @return
     */
    public static String createToken(String userId,String phoneNum){
        return createToken(userId,phoneNum,secret,30);
    }

    /**
     * 解析token
     * @param token
     * @return
     */
    public static Claims parseToken(String token,String key) {
        if ("".equals(token)) {
            return null;
        }

        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(key))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 生成token
     * @param userId
     * @return
     */
    public static String createToken(String userId,String userName,String key, int expireMinutes) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        long currentTimeMillis = System.currentTimeMillis();
        long l = currentTimeMillis + expireMinutes * 1000 * 60;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder()
                .claim("userId", userId) // 设置载荷信息
                .claim("userName",userName)
//                .setExpiration(new Date(l))// 设置超时时间
                .signWith(signatureAlgorithm, signingKey);

        //生成JWT
        return builder.compact();
    }

}
