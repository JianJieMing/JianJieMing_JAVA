package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = "/adminjsps/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String admin = (String) request.getSession().getAttribute("admin");
        if (admin==null){
            req.getRequestDispatcher("/adminjsps/login.jsp").forward(req,resp);
        }else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {

    }


}
