package com.jianjieming.dev.html;

import java.util.List;

public class Body {
    private List<Row> rows;

    public Body(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tbody>");
        for (Row row : rows) {
            sb.append(row.toString());
        }
        sb.append("</tbody>");
        return sb.toString();
    }
}
