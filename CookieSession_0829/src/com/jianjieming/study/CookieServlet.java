package com.jianjieming.study;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 铭
 * DATE: 18/8/29 下午2:50
 */
@WebServlet(name = "CookieServlet", urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // cookie 是什么?
        // cookie 是浏览器缓存数据的一种技术.
        // cookie 是保存在浏览器中的,以key-value的形式保存数据.
        // response(响应)会告知浏览器保存哪些数据.
        // 并且在下次请求同一个网站的时候,会把这些信息都再次发送给服务器.

        // 1.看一下浏览器都缓存了哪些cookie.
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");


        // 2.通知浏览器缓存某个数据.
        //   这样浏览器下次再发送请求,会把数据携带一起.
        Cookie cookie = new Cookie("name", "zhangshan");
        // 默认情况下,在浏览器关闭的时候,会把cookie清除掉.
        // 手动指定cookie的过期时间.
        // 设置了cookie过期时间之后,就算浏览器关闭了,
        // 这个cookie也会保存在浏览器中,
        // 下次访问网站的时候,也会携带这个cookie.
        // 这个超时时间是绝对时间,不会因为再次访问网站而更新.
        cookie.setMaxAge(30);
        response.addCookie(cookie);

        // cookie 最大为4Kb.
        // 一次请求或响应cookie最大为20个.
        // 一个服务端最多要求浏览器缓存20个cookie.

        // 正常情况下一个浏览器最多保存300个cookie,
        // 但是,基本没有正常的浏览器.

        // 那么这个cookie只会在访问login地址的时候会发送.
        // 或者/login的子路径, /login/xxx/ooo/sss/
        cookie.setPath("/login");
        // 在哪个域名下会生效.
        // baidu.com(一级域名)    pan.baidu.com(二级域名)   tieba.baidu.com
        cookie.setDomain("/localhost");

//        Cookie cookie = new Cookie("key","value");
//        cookie.setMaxAge(-1);
//        response.addCookie(cookie);
//        Cookie[] cookies = request.getCookies();
    }
}
