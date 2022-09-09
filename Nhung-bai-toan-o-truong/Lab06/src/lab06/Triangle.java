package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Triangle extends Shape{
    private DoubleProperty Ax = new SimpleDoubleProperty();
    private DoubleProperty Ay = new SimpleDoubleProperty();
    private DoubleProperty Bx = new SimpleDoubleProperty();
     private DoubleProperty By = new SimpleDoubleProperty();
    
    public DoubleProperty aXProperty() {
        return Ax;
    }

    public void setAx(double x) {
        this.Ax.setValue(x);
    }
    
    public double getAx(){
        return Ax.get();
    }
    public DoubleProperty aYProperty() {
        return Ay;
    }

    public void setAy(double y) {
        this.Ay.setValue(y);
    }
    
    public double getAy(){
        return Ay.get();
    }
    public DoubleProperty bXProperty() {
        return Bx;
    }

    public void setBx(double x) {
        this.Bx.setValue(x);
    }
    
    public double getBx(){
        return Bx.get();
    }
    
    public DoubleProperty bYProperty() {
        return By;
    }

    public void setBy(double x) {
        this.By.setValue(x);
    }
    
    public double getBy(){
        return By.get();
    }
    
    public Triangle(){}
    public Triangle(double a, double b, double c,double d){
        this.Ax.setValue(a);
        this.Ay.setValue(b);
        this.Bx.setValue(c);
        this.By.setValue(d);
    }
    public Triangle(double x, double y, String mau, double a, double b, double c,double d){
        setPosX(x);
        setPosY(y);
        setMau(mau);
        this.Ax.setValue(a);
        this.Ay.setValue(b);
        this.Bx.setValue(c);
        this.By.setValue(d);
    }
    
    public String toString(){
        return "Triangle";
    }
}
