package Test01.staff;

import Test01.base.Staff;
import Test01.entity.GoodsList;
import Test01.equipment.GoodsShelf;

/**
 * 工人
 * 继承职业类
 *
 * @author 铭
 */
public class Worker extends Staff {
    private ListFileReader reader;

    public Worker() {
//        reader = new DefaultListReader();
        reader = new Test();
    }

    /**
     * 读取清单信息,为货架上货
     * @param list 需要读取的清单信息
     * @param shelf 货架对象
     * @return 上货是否成功
     */
    public boolean store(GoodsList list, GoodsShelf shelf) {
        System.out.println(getName() + "开始上货: ");
        return reader.store(list, shelf);
    }

    public void setListFileReader(ListFileReader reader) {
        this.reader = reader;
    }

}
