package utils;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author 铭
 */
public interface ResultHandler<T> {

    List<T> handle(Statement st, String sql) throws SQLException;

}
