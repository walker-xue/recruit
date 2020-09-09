package com.ncs.recruit.infrastructure.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.github.skunk.core.date.DateUtils;
import com.sun.istack.NotNull;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserTokenProvider implements Serializable {

    /**
     * 密钥
     */
    private final String secret = "code4fun";

    final static Long TIMESTAMP = 86400000L;
    final static String TOKEN_PREFIX = "Bearer";

    /**
     * 从数据声明生成令牌
     *
     * @param claims
     *     数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + TIMESTAMP);
        return TOKEN_PREFIX + " " +
            Jwts.builder().setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token
     *     令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(@NotNull String token) {

        Validate.notBlank(token);

        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage(), e);
            return null;
        }
    }

    /**
     * 生成令牌
     *
     * @param userDetails
     *     用户
     * @return 令牌
     */
    public String generateToken(UserDetails userDetails) {

        Validate.notNull(userDetails);

        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", DateUtils.nowDate());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token
     *     令牌
     * @return 用户名
     */
    public String getUsernameFromToken(@NotNull String token) {

        Validate.notBlank(token);

        try {
            Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage(), e);
            return null;
        }
    }

    /**
     * 判断令牌是否过期
     *
     * @param token
     *     令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        Validate.notBlank(token);

        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage(), e);
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token
     *     原令牌
     * @return 新令牌
     */
    public String refreshToken(@NotNull String token) {
        Validate.notBlank(token);
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", DateUtils.nowDate());
            return generateToken(claims);
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage(), e);
            return null;
        }
    }

    /**
     * 验证令牌
     *
     * @param token
     *     令牌
     * @param userDetails
     *     用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        Validate.notBlank(token);
        Validate.notNull(userDetails);

        CustomUserDetails user = (CustomUserDetails) userDetails;
        String username = getUsernameFromToken(token);

        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
}