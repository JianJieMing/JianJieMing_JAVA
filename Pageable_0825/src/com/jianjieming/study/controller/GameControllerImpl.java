package com.jianjieming.study.controller;

import com.jianjieming.study.common.ResultWrapper;
import com.jianjieming.study.servIce.GameService;
import com.jianjieming.study.servIce.IGameService;

/**
 * @author 铭
 */

/*
    Controller层,一般用来处理前端传送过来的数据.
 */
public class GameControllerImpl implements GameController {

    private IGameService gameService = new GameService();

    @Override
    public ResultWrapper findGames(int page, int count) {
        // 由于前端传递过来的参数已经在Servlet处理完了,
        // 所以该层没有什么业务逻辑了,
        // 直接把数据传递到Service层进行处理.

        if (page <= 0 || count <= 0) {
            return ResultWrapper.error(407, "页码或行数不能小于等于0");
        }

        return this.gameService.games(page, count);
    }
}
