package com.jianjieming.study.filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 铭
 * DATE: 18/8/30 下午3:33
 */
@WebFilter(filterName = "JsonCacheFilter", urlPatterns = "*.json")
/*
    urlPatterns规则:
        /* 表示所有网址.
        /abc/def/* 可以匹配 /abc/def/sadsafwad/asdsa/dwd
        *.jsp 可以匹配: a.jsp /a/s/s/d/v.jsp
        要么就写一个具体的地址,只匹配这一个.
*/
public class JsonCacheFilter extends HttpFilter {

    private Map<String, String> cache = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 转为线程安全的M11ap.
        cache = Collections.synchronizedMap(cache);
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
/*      要做的功能:
        查询数据的时候,只有第一次请求,会去数据库中做查询,
        以后如果想要请求同样的数据,从缓存中取.
        根据请求的地址和请求的参数就可以区分不同的数据,
        所以我们创建一个Map,用来缓存数据,key为网址和请求参数,value为对应的json数据.
*/
        resp.setContentType("application/json;charset=UTF-8");
//      问题:
//        1. 如何生成这个key.
        String method = req.getMethod();
        if ("get".equalsIgnoreCase(method)) {
            // 如果是GET请求才过滤.
            String key = parseRequestToKey(req);
            String json = cache.get(key);
            if (json == null) {
                // 代表这个地址没有缓存.
                HttpCacheResponse response = new HttpCacheResponse(resp);
                // 把增强功能的response对象放行.
                // 前往doget.
                filterChain.doFilter(req, response);
                // 2.如何从响应中拿到数据.
                //   拿到数据之后,存到cache中.
                String jsonData = response.getResponseBody();
                cache.put(key, jsonData);
                // 把数据返回给前端.
                // 把数据写入到原始的输出流中.
                resp.getWriter().println(jsonData);
            } else {
                // 拿到了缓存.
                resp.getWriter().println(json);
            }
            return;
        } else {
            filterChain.doFilter(req, resp);
        }
//        2. key的规则: 请求方法:url?请求参数


    }

    private String parseRequestToKey(HttpServletRequest req) {
        String method = req.getMethod();
        String requestURI = req.getRequestURI();
        Map<String, String[]> parameterMap = req.getParameterMap();

        StringBuilder sb = new StringBuilder();
        sb.append(method)
                .append(":")
                .append(requestURI)
                .append("?");

        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String key = entry.getKey();
            String[] value = entry.getValue();
            for (String s : value) {
                sb.append(key)
                        .append("=")
                        .append(s)
                        .append("&");
            }
        }
        // 删除最后一个&符号
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
