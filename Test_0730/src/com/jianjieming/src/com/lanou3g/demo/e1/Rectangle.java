package com.jianjieming.src.com.lanou3g.demo.e1;

public class Rectangle implements Shape {

    private float height;
    private float width;

    public Rectangle(float height, float width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public float perimeter() {
        return (height + width) * 2;
    }

    @Override
    public float area() {
        return height * width;
    }
}
