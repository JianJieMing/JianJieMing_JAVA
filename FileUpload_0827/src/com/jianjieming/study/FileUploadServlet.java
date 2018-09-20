package com.jianjieming.study;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/8/27 下午3:29
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = "/file-upload")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        // 获取输出流.
        PrintWriter out = response.getWriter();

        // 获取真实路径.
        String dirPath = getServletContext().getRealPath("files");
        // 创建文件夹.
        File file = new File(dirPath);
        // 如果文件不存在,创建一个文件夹.
        if (!file.exists()) {
            file.mkdirs();
        }
        // 使用该类处理前端post过来的multipart/form-data数据.
        ServletFileUpload up = new ServletFileUpload();
        // 设置文件项(FileItem)工厂.
        // 这个Factory对象会在系统的内部创建FileItem.
        up.setFileItemFactory(new DiskFileItemFactory());
        // 为文件项的fileName设置编码格式.
        up.setHeaderEncoding("utf8");
        // 单个文件的最大大小.
        up.setFileSizeMax(2 * 1024 * 1024);
        // 一次表单提交的最大值.
        up.setSizeMax(5 * 1024 * 1024);

        try {
            // 解析请求.
            List<FileItem> fileItems = up.parseRequest(request);
            for (FileItem item : fileItems) {
                if (item.isFormField()) {
                    // 如果是表单属性(也就是说这个文件项不是文件)
                    continue;
                }
//                item.getContentType();
                // 返回这个文件项的ContentType.
                // 如果这个文件项是 formField,那么没有ContentType.

//                item.getFieldName();
                // 返回该文件项上传的时候的key,
                // 也就是html中的input的name属性的值.

//                item.getName();
                // 这个文件项的文件名.

//                item.getSize();
                // 这个文件项的文件大小.

                // 在dirPath文件夹下创建一个名为: item.getName 的文件.
                File file1 = new File(dirPath, item.getName());
                item.write(file1);
//                file1.getAbsolutePath()
            }
            out.println("文件上传成功!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
