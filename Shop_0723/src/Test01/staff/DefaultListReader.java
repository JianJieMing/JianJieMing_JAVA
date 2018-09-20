package Test01.staff;

import Test01.entity.Goods;
import Test01.entity.GoodsList;
import Test01.equipment.GoodsShelf;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 实现接口
 *
 * @author 铭
 */
public class DefaultListReader implements ListFileReader {

    @Override
    public boolean loadListToShelf(GoodsList list, GoodsShelf shelf) {
//        获取清单名称
        String listName = list.getName();
//        将清单名称设置给货架
        shelf.setName(listName);
//        获取清单文件路径
        String path = list.getPath();

        try (
                FileReader r = new FileReader(path);
                BufferedReader br = new BufferedReader(r);
        ) {
            String line = null;
            while ((line = br.readLine()) != null) {
//                解析读到的字符串
                String[] data = line.split(",");
//                创建商品对象
                Goods g = new Goods();
//                把数组第0位的id赋值给商品对象id
                g.setId(Integer.parseInt(data[0]));
//                商品名称
                g.setName(data[1]);
//                商品价格
                g.setPrice(Float.parseFloat(data[2]));
//                货物数量
                int quantity = Integer.parseInt(data[3]);
//                计量单位
                g.setUnit(data[4]);
//                将商品和数量添加到货物
                shelf.addGoods(g, quantity);
            }
//            如果没有出现异常,返回true,证明货架上架成功
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            出现任意异常都认为货物上架失败,返回false
            return false;
        }

    }

    @Override
    public boolean store(GoodsList list2, GoodsShelf shelf2) {
        return false;
    }
}
