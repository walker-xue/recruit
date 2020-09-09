package com.ncs.recruit.infrastructure.security.filter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.google.common.net.HttpHeaders;
import com.ncs.recruit.infrastructure.security.UnauthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
 * 验证用户认证信息
 *
 * @author walker
 */
@Slf4j
public class JwtVerifyFilter extends GenericFilterBean {

    protected static final String HTTP_STATUS_KEY = "HttpStatus";
    protected static final String MESSAGE_KEY = "message";

    /**
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (Objects.isNull(jwtToken) || !jwtToken.contains("Bearer")) {
            throw new UnauthorizedException("未授权登录");
            //            Map<String, Object> parameters = new HashMap<>();
            //            parameters.put(MESSAGE_KEY, "未授权登录");
            //            parameters.put(HTTP_STATUS_KEY, 406);
            //            response.setHeader("status", "406");
            //            log.debug(response.getStatus() + "==================");
            //            PrintWriter out = response.getWriter();
            //            out.write(JSON.toJSONString(parameters));
            //            out.flush();
            //            out.close();
            //            return;
        }

        log.debug(jwtToken);

        Claims claims = Jwts.parser()
            .setSigningKey(JwtLoginFilter.SEED)
            .parseClaimsJws(jwtToken.replace("Bearer", ""))
            .getBody();

        String username = claims.getSubject();//获取当前登录用户名

        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(token);

        chain.doFilter(request, servletResponse);

    }
}