package com.works.configs;

import com.works.entities.Customer;
import com.works.entities.Info;
import com.works.repositories.InfoRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class GlobalFilter implements Filter {

    final InfoRepository infoRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("Server UP");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String url = req.getRequestURI();
        String sessionId = req.getSession().getId();
        String agent = req.getHeader("User-Agent");
        String ip = req.getRemoteAddr();
        String userEmail = "";
        String userTime = ""+System.currentTimeMillis();

        boolean loginStatus = true;
        String[] freeUrls = {"/", "/login"};
        for (String freeUrl : freeUrls) {
            if (url.equals(freeUrl)) {
                loginStatus = false;
                break;
            }
        }

        if (loginStatus) {
            Object objSession = req.getSession().getAttribute("customer");
            if (objSession != null) {
                // Customer customer = (Customer) objSession;
                String customer = (String) objSession;
                userEmail = customer;
                filterChain.doFilter(req, res);
            }else {
                res.sendRedirect("/");
            }
        }else {
            filterChain.doFilter(req, res);
        }

        Info i = new Info(null, url, userEmail, agent, ip, sessionId, userTime);
        infoRepository.save(i);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
        System.out.println("Server DOWN");
    }

}
