package category.service;

import category.dao.CategoryDao;
import category.domain.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    public List<Category> findAll() throws SQLException {
        List<Category> bookClass = categoryDao.findAll();
        return bookClass;
    }

    public Category findOne(String cid) throws SQLException {
        Category category = categoryDao.findOne(cid);
        return category;
    }
}
