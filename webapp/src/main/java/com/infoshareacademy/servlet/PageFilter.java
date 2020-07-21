package com.infoshareacademy.servlet;

import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/search"},
        initParams = {@WebInitParam(name = "minPage", value = "1")})
public class PageFilter implements Filter {

    private Double minPage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.minPage = Double.parseDouble(filterConfig.getInitParameter("minPage"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String currentPage = servletRequest.getParameter("page");

        if (StringUtils.isEmpty(currentPage))

     /*   if (currentPage < minPage) {
            servletRequest.setAttribute("salary", minPage);
        } else servletRequest.setAttribute("salary", userSalary);
        filterChain.doFilter(servletRequest, servletResponse);*/
    }
}
