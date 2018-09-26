package com.jianjieming.study;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author 铭
 * 2018/9/26 9:45
 */

public class LoggerTest {
    @Test
    public void logTest(){
        Logger logger = Logger.getLogger(LoggerTest.class);//获取logger对象
        logger.error("Error 日志");
        logger.warn("warn 日志");
        logger.info("info 日志");
        logger.debug("debug 日志");
    }
}
