package com.infoshareacademy.servlet.servletDao;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/search"},
        initParams = {@WebInitParam(name = "defaultPage", value = "1")})
public class PageFilter implements Filter {

    private Integer page;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.page = Integer.parseInt(filterConfig.getInitParameter("defaultPage"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String pageParam = servletRequest.getParameter("page");

        if (StringUtils.isEmpty(pageParam)) {
            servletRequest.setAttribute("page",page);
        }
        if (NumberUtils.isNumber(pageParam) && Integer.parseInt(pageParam) <= 0) {
            servletRequest.setAttribute("page",page);
        }
        else if (NumberUtils.isNumber(pageParam) && Integer.parseInt(pageParam) >= 1){
            servletRequest.setAttribute("page",pageParam);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
