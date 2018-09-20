package admin.dao;

import admin.domain.Category;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/1 下午5:24
 */
public interface CategoryDao {

    // 添加分类
    boolean addClassify(String classify);

    // 查询分类
    List<Category> selectClassify();

    // 修改分类
    boolean updateClassify(String classify, String cname);

    // 删除分类
    boolean deleteClassify(String classify);

}
