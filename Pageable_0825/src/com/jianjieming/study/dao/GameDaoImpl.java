package com.jianjieming.study.dao;

import com.jianjieming.study.bean.GameBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author 铭
 */
public class GameDaoImpl implements GameDao {

    private ComboPooledDataSource ds = new ComboPooledDataSource();
    private QueryRunner runner = new QueryRunner();

    @Override
    public int queryTotalCount() throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "select COUNT(game_id) as count from Games";
            Map<String, Object> map = runner.query(conn, sql, new MapHandler());
            int count = Integer.parseInt(String.valueOf(map.get("count")));
            System.out.println(sql);
            return count;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Override
    public List<GameBean> queryLimit(int offset, int count) throws Exception {
        Connection conn = ds.getConnection();
        try {
            String sql = "select * from Games limit ?,?";
            Object[] params = {offset, count};
            BeanListHandler<GameBean> handler = new BeanListHandler<>(GameBean.class, new BasicRowProcessor(new GenerousBeanProcessor()));
            List<GameBean> items = runner.query(conn, sql, handler, params);
            System.out.println(sql);
            return items;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
