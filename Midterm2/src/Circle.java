/**
 * Created by lrraymond13 on 11/23/14.
 */
public class Circle extends GeometricObject {
    private double radius;
    private static double pi = 3.14;

    public Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle() {
        this(1);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Circle.pi*radius*radius;
    }
    public double getDiameter() {
        return 2*radius;

    }
    public double getPerimeter() {
        return getDiameter()*Circle.pi;

    }
    public String toString() {
        return super.toString() + "Area is "+ getArea();
    }
}
