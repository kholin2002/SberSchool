package ru.sber.javaschool;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    private Point p0 = new Point(0, 0);
    private Point p1 = new Point(2, 4);
    private Point p2 = new Point(5, 8);

    @Test
    public void distanceFromStart1() {
        Assert.assertEquals(4.472135955, p1.distanceFromStart(), 0.001);
    }

    @Test
    public void distanceFromStart2() {
        Assert.assertEquals(0.0, p0.distanceFromStart(), 0.001);
    }

    @Test
    public void distanceFrom1() {
        Assert.assertEquals(5.0, p1.distanceFrom(p2), 0.001);
    }

    @Test
    public void distanceFrom2() {
        Assert.assertEquals(p2.distanceFrom(p1), p1.distanceFrom(p2), 0.001);
    }

    @Test
    public void getMiddlePoint() {
        Assert.assertEquals(new Point(3, 6), p1.getMiddlePoint(p2));
    }
}