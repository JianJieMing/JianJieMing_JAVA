package unit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 所有!!!!!!!
 * 继承这个 BaseServlet 的 Servlet
 * 请求中 参数必须有 method 这个参数
 * 无论 get 还是 post
 * method 就是 前端 告诉 后端 调用它的 哪个方法
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数 即 要执行的方法名
        String method = req.getParameter("method");
        // 开启反射
        Class clazz = this.getClass();
        // 找方法
        try {
            //传进 方法名 和 这个方法的参数类型
            Method m = clazz.getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            //让这个方法 能够被调用(私有也行)
            m.setAccessible(true);
            //执行找到的方法
            m.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            String errorMsg = "前端的method参数为:" + method + ",但是在你的" +
                    clazz.getSimpleName() + "中找不到 方法名为: " + method +
                    "的方法,你写错了";
            throw new RuntimeException(errorMsg);
        } catch (NullPointerException e) {
            String errorMsg = "前端没有传递method参数";
            throw new RuntimeException(errorMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
