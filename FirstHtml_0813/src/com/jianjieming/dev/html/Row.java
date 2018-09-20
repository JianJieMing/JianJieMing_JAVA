package com.jianjieming.dev.html;

import java.util.List;

public class Row {
    private List<? extends Cell> cells;

    public Row(List<? extends Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<tr>");
        for (Cell c : cells) {
            sb.append(c.toString());
        }
        sb.append("</tr>");
        return sb.toString();
    }
}
