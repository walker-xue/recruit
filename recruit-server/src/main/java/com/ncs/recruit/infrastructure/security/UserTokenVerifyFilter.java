package com.ncs.recruit.infrastructure.security;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.net.HttpHeaders;

/**
 * @author walker
 */

public class UserTokenVerifyFilter extends OncePerRequestFilter {

    CustomUserDetailsService customUserService;

    UserTokenProvider tokenProvider;

    public UserTokenVerifyFilter(CustomUserDetailsService customUserService, UserTokenProvider tokenProvider) {
        this.customUserService = customUserService;
        this.tokenProvider = tokenProvider;
    }

    /**
     * 每个请求都被拦截
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        String tokenHead = "Bearer ";

        if (!Objects.isNull(authHeader) && authHeader.startsWith(tokenHead)) {

            String authToken = authHeader.substring(tokenHead.length());
            String username = tokenProvider.getUsernameFromToken(authToken);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //返回jwtUser
                UserDetails userDetails = this.customUserService.loadUserByUsername(username);
                if (tokenProvider.validateToken(authToken, userDetails)) {

                    UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    //将该用户的权限信息存放到threadlocal中
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}