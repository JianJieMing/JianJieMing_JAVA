package com.jianjieming.study.test;

import com.google.gson.JsonParser;
import com.jianjieming.study.bean.TestBean;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/11 上午7:45
 */
public class Test01 {

    @Test
    public void test01() {
        JsonParser parser=new JsonParser();  //创建JSON解析器
        String s = "/Users/dllo/Desktop/java/DLJ180603/课堂代码/Maven_Test01/test.json";
//        List<TestBean> list = new ArrayList<>();
        List<TestBean> list = new ArrayList<>();
        TestBean testBean = new TestBean();
        JSONObject obj = new JSONObject(s); // 将整个数据放到对象中
        if (obj.has("status")) {
            int status = obj.getInt("status");
            testBean.setStatus(status);
        }
        if (obj.has("msg")) {
            String msg = obj.getString("msg");
            testBean.setMsg(msg);
        }
        if (obj.has("count")) {
            int count = obj.getInt("count");
            testBean.setCount(count);
        }
        JSONArray result = obj.getJSONArray("result");
        List<TestBean.ResultBean> resultBeans = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            TestBean.ResultBean resultBean = new TestBean.ResultBean();
            JSONObject json = result.getJSONObject(i);
            if (json.has("lat")) {
                String lat = json.getString("lat");
                resultBean.setLat(lat);
            }
            if (json.has("lng")) {
                String lng = json.getString("lng");
                resultBean.setLat(lng);
            }
            if (json.has("match")) {
                String match = json.getString("match");
                resultBean.setMatch(match);
            }
            resultBeans.add(resultBean);
        }
        testBean.setResult(resultBeans);
        list.add(testBean);


        for (TestBean bean : list) {
            System.out.println(bean);
        }
    }

}
