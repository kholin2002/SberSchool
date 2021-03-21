package ru.sber.javaschool;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Point {
    private final int x;
    private final int y;

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
    * Расстояние от точки до начала координат
    */
    public double getDistanceFromStart() {
        Point sqr = this.multi(this);
        return Math.sqrt(sqr.x + sqr.y);
    }

    /**
     * Найти расстояние между двумя точками
     */
    public double getDistanceFrom(Point otherPoint) {
        Point delta = this.diff(otherPoint);
        return delta.getDistanceFromStart();
    }

    /**
     * Найти координаты точки, расположенной между двумя точками
     */
    public Point getMiddlePoint(Point otherPoint) {
        return this.sum(otherPoint).div(new Point(2, 2));
    }

    /**
     * Попарно сложить координаты
     */
    private Point sum(Point otherPoint) {
        return new Point(this.x + otherPoint.x, this.y + otherPoint.y);
    }

    /**
     * Попарно вычесть координаты
     */
    private Point diff(Point otherPoint) {
        return new Point(this.x - otherPoint.x, this.y - otherPoint.y);
    }

    /**
     * Попарно перемножить координаты
     */
    private Point multi(Point otherPoint) {
        return new Point(this.x * otherPoint.x, this.y * otherPoint.y);
    }

    /**
     * Попарно разделить координаты
     */
    private Point div(Point otherPoint) {
        return new Point(this.x / otherPoint.x, this.y / otherPoint.y);
    }
}
