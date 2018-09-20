package cart.dao.impl;

import cart.bean.CartBean;
import cart.bean.CartBookBean;
import cart.dao.CartDao;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/4 下午2:30
 */
public class CartDaoImpl implements CartDao {

    GxQueryRunner runner = new GxQueryRunner();

    /**
     * 添加购物车
     *
     * @param bid
     * @param count
     * @param uid
     */
    @Override
    public void insert(int bid, int count, int uid) {
        try {
            String sql = "insert into cart (bid,cartCount,uid) values (?,?,?)";
            Object[] result = {bid, count, uid};
            runner.update(sql, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从购物车中查询某个用户的图书信息
     *
     * @param uid
     * @return
     */
    @Override
    public List queryBook(int uid) {
        try {
            String sql = "SELECT b.bid,b.bname,b.price,b.author,b.image,c.cartCount FROM " +
                    "book b LEFT JOIN cart c  ON b.bid = c.bid WHERE c.uid = ?";
            List<CartBookBean> bookBeans = runner.query(sql, new BeanListHandler<>(CartBookBean.class), uid);
            return bookBeans;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从购物车中删除某个用户的图书
     *
     * @param bid
     * @param uid
     */
    @Override
    public void deleteBook(int bid, int uid) {
        try {
            String sql = "delete from cart where bid = ? and uid = ?";
            runner.update(sql, bid, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除某个用户的购物车
     *
     * @param uid
     */
    @Override
    public void emptyCart(int uid) {
        try {
            String sql = "delete from cart where uid = ?";
            runner.update(sql, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询某个用户的购物车中的所有信息
     *
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public CartBean queryCart(int uid, int bid) {
        String sql = "select * from cart where uid =? and bid = ?";
        try {
            CartBean cartBean = runner.query(sql, new BeanHandler<>(CartBean.class), uid, bid);
            return cartBean;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 购物车有相同的书,只更新数量
     *
     * @param cartCount
     * @param uid
     * @param bid
     * @return
     */
    @Override
    public boolean updateCount(int cartCount, int uid, int bid) {
        String sql = "update cart set cartCount = ? where uid = ? and bid = ?";
        try {
            int num = runner.update(sql, cartCount, uid, bid);
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
