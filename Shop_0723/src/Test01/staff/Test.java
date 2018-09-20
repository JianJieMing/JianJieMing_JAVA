package Test01.staff;

import Test01.entity.Goods;
import Test01.entity.GoodsList;
import Test01.equipment.GoodsShelf;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

/**
 * @author 铭
 */
public class Test implements ListFileReader{

    @Override
    public boolean loadListToShelf(GoodsList list, GoodsShelf shelf) {
        return false;
    }

    @Override
    public boolean store(GoodsList list2, GoodsShelf shelf2) {
        //        获取清单名称
        String listName = list2.getName();
//        将清单名称设置给货架
        shelf2.setName(listName);
        SAXReader reader = new SAXReader();
        try {
            Document read = reader.read(new File("goods.xml"));
            Element rootElement = read.getRootElement();
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {
                Goods goods2 = new Goods();
                Element next = iterator.next();
                String name = next.attributeValue("name");
                list2.setName(name);
                System.out.println(list2.getName());
                Iterator<Element> iterator1 = next.elementIterator();
                while (iterator1.hasNext()) {
                    Element next1 = iterator1.next();
                    String id = next1.elementText("id");
                    String name1 = next1.elementText("name");
                    String price = next1.elementText("price");
                    goods2.setId(Integer.parseInt(id));
                    goods2.setName(name1);
                    goods2.setPrice(Float.parseFloat(price));
                    System.out.println(goods2.getId() + goods2.getName() + goods2.getPrice());
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
