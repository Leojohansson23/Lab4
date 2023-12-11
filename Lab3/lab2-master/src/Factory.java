import javax.swing.*;
import java.awt.*;
import java.util.List;


public class Factory extends JPanel {

    public static Car addSaab(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Saab95();
    }

    public static Car addVolvo(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Volvo240();

    }

    public static Car addScania(){
        Point pointx = new Point();
        Car.Points.add(pointx);
        return new Scania();
    }



}









