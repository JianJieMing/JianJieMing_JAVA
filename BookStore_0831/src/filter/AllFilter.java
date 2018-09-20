package filter;

import admin.dao.impl.CategoryImpl;
import admin.domain.Category;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/8/31 下午8:18
 */
@WebFilter(filterName = "AllFilter", urlPatterns = "/*")
public class AllFilter implements Filter {
    private CategoryImpl category = new CategoryImpl();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("utf8");
        req.setCharacterEncoding("utf8");
        List<Category> categories = category.selectClassify();
        request.setAttribute("categories", categories);
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {

    }
}
