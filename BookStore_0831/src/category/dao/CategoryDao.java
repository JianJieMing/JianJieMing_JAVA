package category.dao;

import category.domain.Category;
import com.lanou.jdbc.GxQueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    GxQueryRunner runner = new GxQueryRunner();

    public List<Category> findAll() throws SQLException {
        String sql = "select * from category";
        List<Category> categories = new ArrayList<>();
        List<Category> query = runner.query(sql, new BeanListHandler<>(Category.class));
        for (Category category : query) {
            Category category1 = new Category();
            String cid = category.getCid();
            String cname = category.getCname();
            category1.setCid(cid);
            category1.setCname(cname);
            categories.add(category1);
        }
        return categories;
    }

    public Category findOne(String cid) throws SQLException {
        String sql = "select * from category where cid = ?";
        Category category = runner.query(sql, new BeanHandler<>(Category.class), cid);
        return category;
    }

}
