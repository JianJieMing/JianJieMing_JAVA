package com.jianjieming.dev.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSource {

    Connection get() throws SQLException;

}
