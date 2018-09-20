package com.jianjieming.dev;

import com.jianjieming.dev.bean.Score;
import com.jianjieming.dev.db.LanouRunner;
import com.jianjieming.dev.html.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String sql = "select stu.stu_id, stu.stu_name,\n" +
                "ifnull(max(case when sc.course_id = 1 then sc.score end), 0) as 'score_YW',\n" +
                "ifnull(max(case when sc.course_id = 2 then sc.score end), 0) as 'score_SX',\n" +
                "ifnull(max(case when sc.course_id = 3 then sc.score end), 0) as 'score_YY',\n" +
                "ifnull(sum(sc.score), 0) as 'score'\n" +
                "from t_students stu\n" +
                "cross join t_courses crs\n" +
                "left join t_score sc on stu.stu_id = sc.stu_id and crs.course_id = sc.course_id\n" +
                "group by stu.stu_id";
        List<Score> scores = LanouRunner.findAll(sql, Score.class);
        TH cell1 = new TH("学号");
        TH cell2 = new TH("姓名");
        TH cell3 = new TH("语文");
        TH cell4 = new TH("数学");
        TH cell5 = new TH("英语");
        TH cell6 = new TH("总分");
        List<TH> ths = new ArrayList<>();
        ths.add(cell1);
        ths.add(cell2);
        ths.add(cell3);
        ths.add(cell4);
        ths.add(cell5);
        ths.add(cell6);
        Row headerRow = new Row(ths);
        List<Row> headerRows = new ArrayList<>();
        headerRows.add(headerRow);
        Head header = new Head(headerRows);


        List<Row> bodyRows = new ArrayList<>();
        for (Score sc : scores) {
            TD num = new TD(sc.getStuId());
            TD name = new TD(sc.getStuName());
            TD scYW = new TD(sc.getScoreYW());
            TD scSX = new TD(sc.getScoreSX());
            TD scYY = new TD(sc.getScoreYY());
            TD score = new TD(sc.getScore());
            List<TD> cells = new ArrayList<>(6);
            cells.add(num);
            cells.add(name);
            cells.add(scYW);
            cells.add(scSX);
            cells.add(scYY);
            cells.add(score);
            Row row = new Row(cells);
            bodyRows.add(row);

        }
        Body body = new Body(bodyRows);
        Table table = new Table("成绩表", header, body);

        StringBuilder sb = new StringBuilder();
        String preHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>";
        sb.append(preHtml);
        sb.append(table.toString());
        String footHtml = "</body>\n" +
                "</html>";
        sb.append(footHtml);

        FileWriter wr = new FileWriter("test.html");
        wr.write(sb.toString());
        wr.close();
    }
}
