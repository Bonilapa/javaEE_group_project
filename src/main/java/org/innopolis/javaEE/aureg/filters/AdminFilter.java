package org.innopolis.javaEE.aureg.filters;

import org.innopolis.javaEE.aureg.controller.AdminEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/editAdmin")
public class AdminFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(AdminEdit.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) {

        String admin = (String) ((HttpServletRequest) servletRequest)
                .getSession().getAttribute("rights");

        if ("admin".equals(admin)) {

            System.out.println(admin);
                LOGGER.debug("AdminFilter. user = admin");

            try {

                filterChain.doFilter(servletRequest, servletResponse);

            } catch (IOException e) {

                LOGGER.error("IOException. AdminFilter.doFilter().", e);

            } catch (ServletException e) {

                    LOGGER.error("ServletException. AdminFilter.doFilter().", e);
            }

        } else {
            if("user".equals(admin)){

                LOGGER.debug("AdminFilter. user != admin");

                try {

                    ((HttpServletResponse) servletResponse)
                            .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/error");

                } catch (IOException e) {

                    LOGGER.error("IOException. AdminFilter redirects to /error.", e);
                }
            }else {
                LOGGER.debug("AdminFilter. user unknown");

                try {

                    ((HttpServletResponse) servletResponse)
                            .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/auth");

                } catch (IOException e) {

                    LOGGER.error("IOException. AdminFilter redirects to /auth.", e);
                }

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