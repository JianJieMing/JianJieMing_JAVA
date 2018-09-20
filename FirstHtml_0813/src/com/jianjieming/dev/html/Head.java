package com.jianjieming.dev.html;

import java.util.List;

public class Head {
    private List<Row> rows;

    public Head(List<Row> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<thead>");
        for (Row row : rows) {
            sb.append(row.toString());
        }
        sb.append("</thead>");
        return sb.toString();
    }
}
