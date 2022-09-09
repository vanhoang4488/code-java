package cau2;

public class Rectangle extends Shape{
    private double width;
    private double length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    
    public Rectangle(){}
    public Rectangle(double width, double length){
       this.width = width;
       this.length = length;
    }
    public Rectangle(double width, double length, String color, boolean filled){
       this.width = width;
       this.length = length;
       setColor(color);
       setFilled(filled);
    }
    public double getArea(){
        return 2*(width + length);
    }
    public double getPerimter() {
        return width*length;
    }
    public String toString(){
        String s = "" + getArea() + getPerimter();
        return s;
    }
}

class Square extends Rectangle{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    
    public void setWidth(double side) {
        this.side = side;
    }
    
    public void setLength(double side) {
        this.side = side;
    }
    
    public Square(){}
    public Square(double side){
       this.side = side;
    }
    public Square(double side, String color, boolean filled){
       this.side = side;
       setColor(color);
       setFilled(filled);
    }
    public double getArea(){
        return 4*side;
    }
    public double getPerimter() {
        return side*side;
    }
    public String toString(){
        String s = "" + getArea() + getPerimter();
        return s;
    }
}