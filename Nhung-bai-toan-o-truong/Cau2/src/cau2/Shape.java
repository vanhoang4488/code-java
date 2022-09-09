package cau2;

abstract public class Shape {
    private String color = "red";
    private boolean filled = true;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public Shape(){}
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    
    public String toString(){
       return color;
    }
}

class Cricle extends Shape {
    private double radius;
    private final double PI = 3.14;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Cricle(){}
    public Cricle(double radius){
       this.radius = radius;
    }
    public Cricle(double radius, String color, boolean filled){
       this.radius = radius;
       setColor(color);
       setFilled(filled);
    }
    public double getArea(){
        return 2*PI*radius;
    }
    public double getPerimter() {
        return PI*radius*radius;
    }
    public String toString(){
        String s = "" + getArea() + getPerimter();
        return s;
    }
}
