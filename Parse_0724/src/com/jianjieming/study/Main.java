package com.jianjieming.study;

import com.jianjieming.study.entity.Album;
import com.jianjieming.study.entity.Music;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        /*
            解析:
                 在特定格式的字符串中提取需要的数据.
         */
//        1. 获取Document对象.
        SAXReader reader = new SAXReader();
        try {
//            1.1 read方法的参数中可以填File/字符输入流/字节输入流等等...
            Document read = reader.read(new File("album-list.xml"));
//            2. 获取元素 Element:元素 Root:根
            Element rootElement = read.getRootElement();
//            3. 获取某个元素的子元素的迭代器.
//               获取根元素albumList的子元素album的迭代器.
            Iterator<Element> iterator = rootElement.elementIterator();
//            遍历所有的album元素.
            while (iterator.hasNext()) {
                Element albumEle = iterator.next();
//                4. 获取某个元素的某个属性的值.
//                   获取album元素的name属性的值.
//                   attribute:属性
                String name = albumEle.attributeValue("name");
//                System.out.println(name);
                Album album = new Album();
                album.setAlbumName(name);
                System.out.println(album.getAlbumName());
                Iterator<Element> musiacIterator = albumEle.elementIterator();
                while (musiacIterator.hasNext()) {
                    Element musicEle = musiacIterator.next();
//                    5. 获取某个元素的子元素文本
//                       获取music元素中的id元素所对应的文本信息.
                    String id = musicEle.elementText("id");
                    String musicName = musicEle.elementText("name");
                    String duration = musicEle.elementText("duration");
//                    System.out.println(id);
//                    System.out.println(musicName);
//                    System.out.println(duration);
                    Music music = new Music();
                    music.setMusicName(musicName);
                    music.setDuration(Integer.parseInt(duration));
                    List<Music> musicList = new ArrayList<>();
                    musicList.add(music);
                    album.setMusicList(musicList);
                    System.out.println(album.getMusicList());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
