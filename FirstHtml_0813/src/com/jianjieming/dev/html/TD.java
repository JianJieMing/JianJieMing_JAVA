package com.jianjieming.dev.html;

public class TD extends Cell {
    public TD(Object value) {
        super(value);
    }

    @Override
    public String toString() {
        return "<td>" + getValue() + "</td>";
    }
}
