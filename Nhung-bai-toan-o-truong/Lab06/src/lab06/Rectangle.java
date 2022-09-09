package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class Rectangle extends Shape{
    private DoubleProperty dai = new SimpleDoubleProperty();
    private DoubleProperty rong = new SimpleDoubleProperty();

    public DoubleProperty daiProperty() {
        return dai;
    }

    public void setDai(double dai) {
        this.dai.setValue(dai);
    }
    
    public double getDai(){
        return dai.get();
    }
    
    public DoubleProperty rongProperty() {
        return dai;
    }

    public void setRong(double rong) {
        this.rong.setValue(rong);
    }
    
    public double getRong(){
        return rong.get();
    }
    
    public Rectangle(){}
    public Rectangle(double dai, double rong){
        this.dai.setValue(dai);
        this.rong.setValue(rong);
    }
    public Rectangle(double x, double y, String mau, double a, double b){
        setPosX(x);
        setPosY(y);
        setMau(mau);
        this.dai.setValue(a);
        this.rong.setValue(b);
    }
    public String toString(){
        return "Rectangle";
    }
}
