package com.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 21:16
 */
@Configuration
public class CorsConfig  implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        //*号表示对所有请求都允许跨域访问
        res.setHeader("Access-Control-Allow-Origin","*"); //允许任何域名
        res.addHeader("Access-Control-Allow-Methods", "*");//允许任何方法
        res.setHeader("Access-Control-Allow-Headers", "*"); //允许任何头
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
