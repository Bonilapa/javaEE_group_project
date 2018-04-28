package org.innopolis.javaEE.aureg.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/editAdmin")
public class AdminFilter implements Filter {

//        private static final Logger LOGGER = LogManager.getLogger(LoginFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) {

        String admin = (String) ((HttpServletRequest) servletRequest)
                .getSession().getAttribute("rights");

        if (admin == "admin") {

//                LOGGER.debug("LoginFilter. userLogin = null");

            try {

                filterChain.doFilter(servletRequest, servletResponse);

            } catch (IOException e) {

//                    LOGGER.error("IOException. LoginFilter.doFilter().");
                e.printStackTrace();

            } catch (ServletException e) {

//                    LOGGER.error("ServletException. LoginFilter.doFilter().");
                e.printStackTrace();
            }

        } else {

//                LOGGER.debug("LoginFilter. userLogin = " + userLogin);

            try {

                ((HttpServletResponse) servletResponse)
                        .sendRedirect(((HttpServletRequest) servletRequest).getContextPath() + "/auth");

            } catch (IOException e) {

//                    LOGGER.error("IOException. LoginFilter redirects to /index.");
                e.printStackTrace();
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