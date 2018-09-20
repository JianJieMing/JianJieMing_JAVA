package com.jianjieming.sping.test1;

/**
 * @author 铭
 * DATE: 18/9/11 下午2:42
 */
public class PaperFactory {

    private static Paper paper;

    public static Paper getStaticPaper() {
        if (paper == null) {
            paper = new Paper();
        }
        return paper;
    }

    public Paper getPaper() {
        return new Paper();
    }

}
