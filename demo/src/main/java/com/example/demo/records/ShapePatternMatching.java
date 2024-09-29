package com.example.demo.records;

public class ShapePatternMatching {

    public static void main(String[] args) {

        //Shape shape = new Rectangle(4.0, 5.0);
        //Shape shape = new Circle(5.5);
        Shape shape = new Square(3.25);

        String result = switch (shape) {
            case Circle(double radius) -> "Circle with radius: " + 2 * (22 / 7) * radius;
            case Rectangle(double length, double width) -> "Rectangle with length: " + (length + width) * 2;
            case Square(double side) -> "Square with side: " + side * 4;
            default -> "Unknown shape";
        };

        System.out.println(result);
    }
}

