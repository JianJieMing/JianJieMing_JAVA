package com.jianjieming.study.servIce;

import com.jianjieming.study.bean.GameBean;
import com.jianjieming.study.common.ResultWrapper;
import com.jianjieming.study.dao.GameDao;
import com.jianjieming.study.dao.GameDaoImpl;

import java.util.List;

/**
 * @author 铭
 */
public class GameService implements IGameService {

    private GameDao gameDao = new GameDaoImpl();

    @Override
    public ResultWrapper games(int page, int count) {

        try {
//            1. 把page进行计算得到limit参数.
            int offset = (page - 1) * count;

//            2. 查询数据总数.
            int totalCount = gameDao.queryTotalCount();

//            3. 查询需要的数据.
            List<GameBean> items = gameDao.queryLimit(offset, count);

//            4. 处理异常.
//            5. 数据整合为ResuleWrapper.
            return ResultWrapper.success(totalCount, items);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultWrapper.error(406, "您查询的数据不存在");
        }
    }
}
