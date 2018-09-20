package com.jianjieming.study.common;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 铭
 */
public interface ConnectionSource {

    Connection get() throws SQLException;

}
