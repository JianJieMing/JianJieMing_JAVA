package cart.dao;

import cart.bean.CartBean;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/4 下午2:20
 */
public interface CartDao {
    // 添加购买数量
    void insert(int bid, int count, int uid);

    // 根据用户id查询用户的购物车
    List queryBook(int uid);

    // 根据书的id删除图书
    void deleteBook(int bid,int uid);

    // 清空购物车
    void emptyCart(int uid);

    // 查询书的ID
    CartBean queryCart(int uid, int bid);

    // 更新购物车
    boolean updateCount(int cartCount, int uid, int bid);
}
