package homework.page;

import com.google.gson.Gson;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import homework.bean.GameBean;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/1 下午3:35
 */
@WebServlet(name = "Ajax2Servlet", urlPatterns = "/ajax2")
public class Ajax2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf8");
        request.setCharacterEncoding("utf8");

        PrintWriter writer = response.getWriter();
        ComboPooledDataSource ds = new ComboPooledDataSource();
        QueryRunner runner = new QueryRunner();

        int page = (int) request.getAttribute("page");
        int count = (int) request.getAttribute("count");
        System.out.println(page + count);

        try {
            Connection conn = ds.getConnection();
            String sql = "select * from Games limit ?,?";
            int i = (count - 1) * page;
            Object[] gameList = {i, page};
            List<GameBean> gameBeanList = runner.query(conn, sql, new BeanListHandler<>(GameBean.class, new BasicRowProcessor(new GenerousBeanProcessor())), gameList);
            for (GameBean gameBean : gameBeanList) {
                System.out.println(gameBean);
            }
            String s = new Gson().toJson(gameBeanList);
            writer.println(s);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
