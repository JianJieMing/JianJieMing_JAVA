package com.jianjieming.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 铭
 * DATE: 18/8/30 上午8:42
 */
public class Test01 {
    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<>();
        map.put("姓名","张三");
        map.put("年龄",23);
        map.put("性别","男");

        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key+value);
        }

    }
}
