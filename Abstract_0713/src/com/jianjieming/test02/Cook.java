package com.jianjieming.test02;

/**
 * 厨师类
 * 炒菜的流程
 * 子类不可更改
 *
 * @author 铭
 */
public abstract class Cook {
    public final void cooking() {
//      1. 开火
        ignition();
//      2. 倒油
        putOil();
//      3. 放菜
        dishes();
//      4. 放调料
        condiment();
//      5. 翻炒
        fry();
    }

    protected void ignition() {
        System.out.println("开火");
    }

    protected void putOil() {
        System.out.println("倒油");
    }

    public abstract void dishes();

    public abstract void condiment();

    protected void fry() {
        System.out.println("翻炒");
    }
}
