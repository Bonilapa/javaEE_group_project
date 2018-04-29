package org.innopolis.javaEE.aureg.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/auth")
public class LoginFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) {

        String admin = (String) ((HttpServletRequest) servletRequest)
                .getSession().getAttribute("rights");

        if ("user".equals(admin) || "admin".equals(admin)) {

            LOGGER.debug("LoginFilter. user unknown");

            try {

                ((HttpServletResponse) servletResponse)
                        .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/hello");

            } catch (IOException e) {

                LOGGER.error("IOException. UserFilter redirects to /hello.", e);
            }

        } else {

            LOGGER.debug("UserFilter. user = user");

            try {

                filterChain.doFilter(servletRequest, servletResponse);

            } catch (IOException e) {

                LOGGER.error("IOException. UserFilter.doFilter().", e);
            } catch (ServletException e) {

                LOGGER.error("ServletException. UserFilter.doFilter().", e);
            }

        }

    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

}