package com.jianjieming.study.servIce;

import com.jianjieming.study.common.ResultWrapper;

/**
 * @author 铭
 */

/*
    声明接口的另一种命名方式,大写 I 开头.
    Service层,一般用来做业务逻辑的处理.
 */
public interface IGameService {

    ResultWrapper games(int page,int count);

}
