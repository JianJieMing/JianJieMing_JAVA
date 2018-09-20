package com.jianjieming.study.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;

/**
 * @author 铭
 * DATE: 18/8/30 下午4:32
 */
public class HttpCacheResponse extends HttpServletResponseWrapper {

    private ByteArrayOutputStream out;

    public HttpCacheResponse(HttpServletResponse response) {
        super(response);
        out = new ByteArrayOutputStream();
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(out, getCharacterEncoding()));
    }

    public String getResponseBody() throws UnsupportedEncodingException {
        // 从字节数组输出流中,获取保存的字节数组.
        byte[] bytes = out.toByteArray();
        // 把字节数组转为字符串.
        return new String(bytes, getCharacterEncoding());
    }
}
