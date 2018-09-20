package com.jianjieming.test1;

/**
 * @author 铭
 */
public class Rectangle implements Shape {

    private float a;
    private float b;

    public Rectangle(float a, float b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public float perimeter() {
        float i = (a + b) * 2;
        return i;
    }

    @Override
    public float area() {
        float x = a * b;
        return x;
    }
}
