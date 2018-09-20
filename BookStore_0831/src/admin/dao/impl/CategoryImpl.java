package admin.dao.impl;

import admin.dao.CategoryDao;
import admin.domain.Category;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/3 上午7:31
 */
public class CategoryImpl implements CategoryDao {
    GxQueryRunner runner = new GxQueryRunner();

    /**
     * 添加分类
     *
     * @param classify
     * @return
     */
    @Override
    public boolean addClassify(String classify) {
        try {
            String sql = "insert into category (cname) values (?)";
            int num = runner.update(sql, classify);
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查询所有分类
     *
     * @return
     */
    @Override
    public List<Category> selectClassify() {
        try {
            String sql = "select * from category";
            List<Category> query = runner.query(sql, new BeanListHandler<>(Category.class));
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 修改分类
     *
     * @param classify
     * @param cname
     * @return
     */
    @Override
    public boolean updateClassify(String classify, String cname) {
        String sql = "update category set cname = ? where cname = ?";
        try {
            int num = runner.update(sql, classify, cname);
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除分类
     *
     * @param classify
     * @return
     */
    @Override
    public boolean deleteClassify(String classify) {
        String sql = "delete from category where cname = ?";
        try {
            int num = runner.update(sql, classify);
            return num == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
