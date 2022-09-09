package lab06;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

abstract public class Shape {
    private DoubleProperty posX = new SimpleDoubleProperty();
    private DoubleProperty posY = new SimpleDoubleProperty();
    private StringProperty mau = new SimpleStringProperty();

    public DoubleProperty posXProperty() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX.setValue(posX);
    }

    public double getPosX() {
        return this.posX.get();
    }
    public DoubleProperty posyProperty() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY.setValue(posY);
    }

    public double getPosY() {
        return this.posY.get();
    }

    public StringProperty mauProperty() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau.setValue(mau);
    }
    
    public String getMau(){
        return this.mau.get();
    }
    public Shape(){}
    public Shape(double posX, double posY, String mau){
        this.posX.setValue(posX);
        this.posY.setValue(posY);
        this.mau.setValue(mau);
    }
}
