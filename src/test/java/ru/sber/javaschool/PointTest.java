package ru.sber.javaschool;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    private Point p0 = new Point(0, 0);
    private Point p1 = new Point(2, 4);
    private Point p2 = new Point(5, 8);

    @Test
    public void getDistanceFromStart1() {
        Assert.assertEquals(4.472135955, p1.getDistanceFromStart(), 0.001);
    }

    @Test
    public void getDistanceFromStart2() {
        Assert.assertEquals(0.0, p0.getDistanceFromStart(), 0.001);
    }

    @Test
    public void getDistanceFrom1() {
        Assert.assertEquals(5.0, p1.getDistanceFrom(p2), 0.001);
    }

    @Test
    public void getDistanceFrom2() {
        Assert.assertEquals(p2.getDistanceFrom(p1), p1.getDistanceFrom(p2), 0.001);
    }

    @Test
    public void getMiddlePoint() {
        Assert.assertEquals(new Point(3, 6), p1.getMiddlePoint(p2));
    }
}