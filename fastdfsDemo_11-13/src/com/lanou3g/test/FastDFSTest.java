package com.lanou3g.test;

import org.csource.common.MyException;
import org.junit.Test;

import java.io.IOException;

/**
 * 创建人: 武奇
 * 创建事件: 2018/11/7
 */
public class FastDFSTest {

    @Test
    public void test() throws IOException, MyException {

        String srcPath = "C:\\Users\\Administrator\\Desktop\\我的资料库\\imgs\\timg-3.jpeg";
        String type = "jpeg";
        String result = UploadUtils.getUpload(srcPath, type);
        System.out.println(result);

    }

}
