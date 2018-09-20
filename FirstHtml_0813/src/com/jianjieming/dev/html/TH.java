package com.jianjieming.dev.html;

public class TH extends Cell {

    public TH(Object value) {
        super(value);
    }

    @Override
    public String toString() {
        return "<th>" + getValue() + "</th>";
    }
}
