package com.jianjieming.study.controller;

import com.jianjieming.study.common.ResultWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author 铭
 */
public class TestGameController implements GameController {

    @Override
    public ResultWrapper findGames(int page, int count) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("gameId", i + 1);
            map.put("gameName", "超级玛丽" + i);
            list.add(map);
        }
        return ResultWrapper.success(78, list);
    }
}
