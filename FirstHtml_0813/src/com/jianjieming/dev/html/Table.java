package com.jianjieming.dev.html;

public class Table {
    private String caption;
    private Head thead;
    private Body tbody;

    public Table(String caption, Head thead, Body tbody) {
        this.caption = caption;
        this.thead = thead;
        this.tbody = tbody;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\" width=\"50%\">");
        sb.append("<caption>");
        sb.append(caption);
        sb.append("</caption>");

        sb.append(thead.toString());
        sb.append(tbody.toString());

        sb.append("</table>");
        return sb.toString();
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Head getThead() {
        return thead;
    }

    public void setThead(Head thead) {
        this.thead = thead;
    }

    public Body getTbody() {
        return tbody;
    }

    public void setTbody(Body tbody) {
        this.tbody = tbody;
    }
}
