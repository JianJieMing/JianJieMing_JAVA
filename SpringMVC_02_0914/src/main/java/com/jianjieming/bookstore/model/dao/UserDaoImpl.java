package com.jianjieming.bookstore.model.dao;

import com.jianjieming.bookstore.model.vo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/14 下午2:37
 */
@Repository
public class UserDaoImpl implements UserDao {

    private SqlSession sqlSession;

    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = factory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> queryAll() {
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.queryAll();
        System.out.println(users);
        return users;
    }

    @After
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }




//    @Test
//    public void showAll() {
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> users = userDao.queryAll();
//        System.out.println(users);
//        return users;

//    }


//    @Override
//    public List<User> queryAll() {
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            User user = new User("影分身" + i + "号", "100" + i);
//            users.add(user);
//        }
//        return users;
//    }
}
