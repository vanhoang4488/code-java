package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Circle extends Shape {
    private DoubleProperty bankinh = new  SimpleDoubleProperty();
    
    public DoubleProperty bankinhProperty() {
        return bankinh;
    }

    public void setBankinh(double bankinh) {
        this.bankinh.setValue(bankinh);
    }
    
    public double getBankinh(){
        return bankinh.get();
    }
    public Circle(){}
    public Circle(double bankinh){
       this.bankinh.setValue(bankinh);
    }
    
    public Circle(double x, double y, String mau, double bankinh){
        setPosX(x);
        setPosY(y);
        setMau(mau);
        this.bankinh.setValue(bankinh);
    }
    public String toString(){
        return "Circle";
    }
}
