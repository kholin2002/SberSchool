package ru.sber.javaschool;

public class Lesson2 {

    public static void main(String[] args) {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(5, 8);
        System.out.printf(
                "Точка 1: %s\nТочка 2: %s\nРасстояние между точками: %.2f\nТочка посередине: %s\n",
                p1, p2, p1.distanceFrom(p2), p1.getMiddlePoint(p2)
        );
    }
}
