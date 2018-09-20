package com.jianjieming.study.dao;

import com.jianjieming.study.bean.GameBean;

import java.util.List;

/**
 * @author 铭
 */
public interface GameDao {

    int queryTotalCount() throws Exception;
    
    List<GameBean> queryLimit(int offset, int count) throws Exception;

}
