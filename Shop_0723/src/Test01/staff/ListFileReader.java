package Test01.staff;

import Test01.entity.GoodsList;
import Test01.equipment.GoodsShelf;

/**
 * 解析器
 *
 * @author 铭
 */
public interface ListFileReader {
    boolean loadListToShelf(GoodsList list, GoodsShelf shelf);

    boolean store(GoodsList list2, GoodsShelf shelf2);
}
