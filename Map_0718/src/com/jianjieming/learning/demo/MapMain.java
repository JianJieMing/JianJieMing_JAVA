package com.jianjieming.learning.demo;

import java.util.*;

public class MapMain {

    public static final String KEY_NAME = "nasdfme";
    public static final String KEY_AGE = "wefwe";
    public static final String KEY_HEIGHT = "he234isfdght";


    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        // Set里面的元素是不可以重复的
        set.add("周一");
        set.add("周二");
        set.add("周三");
        set.add("周四");
        set.add("周一");
        System.out.println(set);

//        Map
        // Map以键值对(key-value)形式存储数据
        // 主要向Map中存储的数据是value,
        // 但是在存储的时候需要给value指定一个标签, 这个标签就是key
        // 声明Map对象时需要指定两个泛型,
        // 第一个泛型是key的类型, 第二个泛型是value的类型
        Map<String, String> map = new HashMap<>();
        // 向Map中存储数据
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        // 从Map中获取数据
        String s = map.get("及时雨");

        Map<String, Object> p1 = new HashMap<>();
        p1.put(KEY_NAME, "张三");
        p1.put(KEY_AGE, 18);
        p1.put(KEY_HEIGHT, 175.8f);
        String name = (String) p1.get(KEY_NAME);
        int age = (int) p1.get(KEY_AGE);

        // Map中的key不能重复
        // 如果存放数据时根据的是同一个key,
        // 那么会覆盖掉之前的数据
        Map<String, Object> p2 = new HashMap<>();
        p2.put(KEY_NAME, "李四");
        p2.put(KEY_AGE, 16);
        p2.put(KEY_HEIGHT, 173.2f);

        Map<String, String> fruit = new HashMap<>();
        fruit.put("红色", "小柿子");
        fruit.put("黄色", "香蕉");
        fruit.put("紫色", "葡萄");
        fruit.put("绿色", "西瓜皮");

        // Map中的元素是无序的
        System.out.println(fruit);
        // 根据key移除数据, 返回值是移除的数据的value
        String f = fruit.remove("紫色");
        System.out.println(f);
        System.out.println("-------");
        // Map的遍历
        // 1. 取到Map的所有key的集合
        Set<String> keys = fruit.keySet();
        // 然后遍历该集合, 根据集合中的元素从map中获取数据
        for (String key : keys) {
            String fru = fruit.get(key);
            System.out.println(key + " --> " + fru);
        }
        // 2. 直接取出所有值的集合
        // 缺点: 不知道key都是什么
        System.out.println("----所有值---");
        Collection<String> values = fruit.values();
        for (String value : values) {
            System.out.println(value);
        }
        // 3. 最常用的一种遍历Map的方式
        Set<Map.Entry<String, String>> entries = fruit.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->>" + value);
        }

        // 在一个集合中放Map对象
        List<Map<String, Object>> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);


        System.out.println("----我是分割线------");
        // 创建一个集合用来保存所有专辑信息
        List<Map<String, Object>> albumList = new ArrayList<>();
        // 创建一个专辑
        Map<String, Object> jayAlbum = new HashMap<>();
        // 把专辑放到集合中
        albumList.add(jayAlbum);
        // 为专辑设置名字
        jayAlbum.put("name", "Jay");
        // 为专辑放入歌曲(歌曲的集合)
        List<Map<String, String>> jayMusics = new ArrayList<>();
        jayAlbum.put("musics", jayMusics);
        // 为歌曲的集合中放入歌曲
        Map<String, String> douNiu = new HashMap<>();
        douNiu.put("musicName", "斗牛");
        douNiu.put("duration", "100");
        jayMusics.add(douNiu);
        Map<String, String> ffxdz = new HashMap<>();
        ffxdz.put("musicName", "反方向的钟");
        ffxdz.put("duration", "200");
        jayMusics.add(ffxdz);
        Map<String, String> hsym = new HashMap<>();
        hsym.put("musicName", "黑色幽默");
        hsym.put("duration", "150");
        jayMusics.add(hsym);

        // 第二张专辑
        Map<String, Object> bdkjAlbum = new HashMap<>();
        albumList.add(bdkjAlbum);
        bdkjAlbum.put("name", "八度空间");

        List<Map<String, String>> bdkjMusics = new ArrayList<>();
        bdkjAlbum.put("musics", bdkjMusics);

        Map<String, String> ah = new HashMap<>();
        bdkjMusics.add(ah);
        ah.put("musicName", "暗号");
        ah.put("duration", "234");

        System.out.println(albumList);

        // 取出第0张专辑的第1首歌曲的时长
        // 第0张专辑
        Map<String, Object> album0 = albumList.get(0);
        // 取这张专辑的所有歌曲
        List<Map<String, String>> musics
                = (List<Map<String, String>>) album0.get("musics");
        // 取第一首歌曲
        Map<String, String> music = musics.get(1);
        // 取歌曲的时长
        String duration = music.get("duration");
        System.out.println(duration);

        // 遍历
        for (Map<String, Object> albumMap : albumList) {
            // 取专辑的名称
            Object albumName = albumMap.get("name");
            System.out.println("专辑的名称: " + albumName);
            // 获取所有歌曲
            List<Map<String,String>> musicList = (List<Map<String, String>>) albumMap.get("musics");
            for (Map<String, String> musicMap : musicList) {
                String musicName = musicMap.get("musicName");
                String musicDuration = musicMap.get("duration");
                System.out.println("\t歌曲名称: " + musicName + ", 时长: " + musicDuration);
            }
        }



    }
}
