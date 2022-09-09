package diagram;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;

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
    
    public Triangle(GraphicsContext gc){
    
        gc.moveTo(30.5, 30.5);
        gc.lineTo(150.5, 30.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(30.5, 30.5);
        gc.stroke();
    }
    
    
    public String toString(){
        return "Triangle";
    }
    
}

