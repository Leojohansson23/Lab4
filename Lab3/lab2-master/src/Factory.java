import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Factory extends JPanel {

    public Saab95 addSaab(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Saab95();
    }

    public Volvo240 addVolvo(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Volvo240();

    }

    public Scania addScania(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Scania();
    }



}









