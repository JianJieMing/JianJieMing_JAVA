package com.jianjieming.learning.map;

import java.util.*;

/**
 * @author 铭
 */
public class MapMain {

    public static final String KEY_NAME = "name";
    public static final String KEY_AGE = "age";
    public static final String KEY_HEIGHT = "height";

    public static void main(String[] args) {

        /*
            Set 里面的元素是不可以重复的,无序的.
         */
        Set<String> set = new HashSet<>();
        set.add("周一");
        set.add("周二");
        set.add("周三");
        set.add("周四");
        set.add("周五");
        set.add("周六");
        set.add("周七");
        set.add("周一");
        System.out.println(set);
        /*
            Map 以键值对(key -- value)形式存储数据.
            主要向Map中存储的数据是value,
            但是在存储的时候需要给value指定一个标签,这个标签就是key.

            声明Map对象时,需要指定两个泛型,
            第一个泛型是key的类型,第二个类型是value的类型.

            Map中的key不能重复,
            如果存放数据时根据的是同一个key,
            那么会覆盖掉之前的数据.

            Map中的元素是无序的.
         */
        Map<String, String> map = new HashMap<>();
//        向Map中存取数据
        map.put("凤雏", "庞统");
        map.put("卧龙", "诸葛亮");
        map.put("及时雨", "宋江");
        map.put("玉麒麟", "卢俊义");
        map.put("入云龙", "公孙胜");
//        向Map中获取数据
        String s = map.get("卧龙");

        Map<String, Object> p = new HashMap<>();
        p.put(KEY_NAME, "张三");
        p.put(KEY_AGE, 18);
        p.put(KEY_HEIGHT, 178.9F);

        String name = (String) p.get("name");
        int age = (int) p.get("age");

        Map<String, Object> p1 = new HashMap<>();
        p1.put(KEY_NAME, "李四");
        p1.put(KEY_AGE, 20);
        p1.put(KEY_HEIGHT, 180.7F);
        System.out.println(s);
        System.out.println(p);
        System.out.println(p1);

        Map<String, String> map1 = new HashMap<>();
        map1.put("红色", "小柿子");
        map1.put("黄色", "香蕉");
        map1.put("紫色", "葡萄");

//        根据key值删除元素
        String purple = map1.remove("紫色");
        System.out.println(purple);

        /*
            Map的遍历
                1. 取到Map的所有key的集合,然后遍历该集合,
                   根据集合中的元素从map中获取数据.
         */
        Set<String> strings = map1.keySet();
        for (String string : strings) {
            String fru = map1.get(string);
            System.out.println(string + "-->" + fru);
        }

        /*
                2. 直接取出所有值的集合.
                   缺点: key值都没了,只能取出value值.
        */

        Collection<String> values = map1.values();
        System.out.println(values);

        /*
            3. 第三种遍历写法,也是最常用的一种遍历Map的方式.
         */

        Set<Map.Entry<String, String>> entries = map1.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "-->" + value);
        }

//        在一个集合中放Map对象
        List<Map<String, Object>> persons = new ArrayList<>();
        persons.add(p);
        persons.add(p1);
        System.out.println(persons);


        System.out.println("*******************");

//        创建一个集合,用来保存所有专辑信息.
        List<Map<String, Object>> album = new ArrayList<>();
//        创建一个专辑
        Map<String, Object> jayAlbum = new HashMap<>();
//        把专辑放到集合中
        album.add(jayAlbum);
//        为专辑设置名字
        jayAlbum.put("name", "Jay");
//        为专辑放入歌曲(歌曲的集合)
        List<Map<String, String>> jayMusics = new ArrayList<>();
        jayAlbum.put("musics", jayMusics);
//        为歌曲的集合中放入歌曲
        Map<String, String> douNiu = new HashMap<>();
        douNiu.put("musicName", "斗牛");
        douNiu.put("duration", "100");
//        将第一首歌放入歌曲的集合中
        jayMusics.add(douNiu);

        Map<String, String> ffxdz = new HashMap<>();
        ffxdz.put("musicName", "反方向的钟");
        ffxdz.put("duration", "200");
//        将第二首歌放入歌曲的集合中
        jayMusics.add(ffxdz);

        Map<String, String> hsym = new HashMap<>();
        hsym.put("musicName", "黑色幽默");
        hsym.put("duration", "150");
//        将第三首歌放入歌曲的集合中
        jayMusics.add(hsym);

//        第二张专辑
        Map<String, Object> bdkjAlbum = new HashMap<>();
        album.add(bdkjAlbum);
        bdkjAlbum.put("name", "八度空间");

        List<Map<String, String>> bdkjMusics = new ArrayList<>();
        bdkjAlbum.put("musics", bdkjMusics);

        Map<String, String> ah = new HashMap<>();
        bdkjMusics.add(ah);
        ah.put("musicName", "暗号");
        ah.put("duration", "159");

        Map<String, String> jht = new HashMap<>();
        bdkjMusics.add(jht);
        jht.put("musicName", "菊花台");
        ah.put("duration", "189");

        Map<String, String> mds = new HashMap<>();
        bdkjMusics.add(mds);
        mds.put("musicName", "满地伤");
        ah.put("duration", "189");

        System.out.println(album);

//        取出第0张专辑的第一首歌曲的时长.

//        取第0张专辑
        Map<String, Object> map2 = album.get(0);
//        取这张专辑的所有歌曲
        List<Map<String, String>> musics = (List<Map<String, String>>) map2.get("musics");
//        取出第一首歌
        Map<String, String> map3 = musics.get(1);
//        取出歌曲时长
        String duration = map3.get("duration");

        System.out.println(duration);

//        遍历

        for (Map<String, Object> stringObjectMap : album) {
//            取专辑名称
            Object name1 = stringObjectMap.get("name");
            System.out.println("专辑名称: " + name1);
//            获取所有歌曲
            List<Map<String, String>> musics5 = (List<Map<String, String>>) stringObjectMap.get("musics");
            for (Map<String, String> stringStringMap : musics5) {
                String name2 = stringStringMap.get("musicName");
                String duration1 = stringStringMap.get("duration");
                System.out.println("\t 歌曲名称:" + name2 + "  歌曲时间: " + duration1);
            }
        }

    }
}
