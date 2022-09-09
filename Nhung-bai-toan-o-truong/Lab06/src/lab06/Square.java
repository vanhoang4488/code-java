package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Square extends Rectangle{
     private DoubleProperty canh = new SimpleDoubleProperty();

    public DoubleProperty canhProperty() {
        return canh;
    }

    public void setCanh(double canh) {
        this.canh.setValue(canh);
    }
     
    public double getCanh(){
        return this.canh.get();
    } 
    public DoubleProperty daiProperty() {
        return canh;
    }

    public void setDai(double canh) {
        this.canh.setValue(canh);
    }
     
    public double getDai(){
        return this.canh.get();
    } 
    
    public Square(){}
    public Square(double canh){
        this.canh.setValue(canh);
    }
    
    public Square(double x, double y, String mau, double a){
        setPosX(x);
        setPosY(y);
        setMau(mau);
        this.canh.setValue(a);
    }
    
    public String toString(){
        return "Square";
    }
}
