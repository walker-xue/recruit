package com.ncs.recruit.infrastructure.security.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    //this is base64 for 'password' as seed
    public static final String SEED = "cGFzc3dvcmQ=";

    public JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));

        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp)
        throws AuthenticationException, IOException, ServletException {

        User user = new ObjectMapper().readValue(req.getInputStream(), User.class);

        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult)
        throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuffer as = new StringBuffer();
        as.append(authorities.stream()
            .map(auth -> ((GrantedAuthority) auth).getAuthority())
            .collect(Collectors.joining(",")));

        String jwt = Jwts.builder()
            .claim("authorities", as)//配置用户角色
            .setSubject(authResult.getName())
            .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
            .signWith(SignatureAlgorithm.HS512, SEED)
            .compact();
        resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        PrintWriter out = resp.getWriter();
        out.write(new ObjectMapper().writeValueAsString(jwt));
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException failed)
        throws IOException, ServletException {
        resp.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        PrintWriter out = resp.getWriter();
        out.write("登录失败!");
        out.flush();
        out.close();
    }
}