package com.jianjieming.study.controller;

import com.jianjieming.study.common.ResultWrapper;

/**
 * @author 铭
 */
public interface GameController {

    ResultWrapper findGames(int page, int count);

}
