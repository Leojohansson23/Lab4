import java.util.ArrayList;
import java.util.Observable;
import java.util.List;

public class Move implements Moveable {

    /*private void updateObservers() {
        Observable.setChanged(true);
        Observable.notifyObservers(getXpos(), getYpos());

    }*/
    /*private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }*/

    private int Direction = 0;

    private double Xpos = 0;
    private double Ypos = 0;
    public double getXpos(){return Xpos;}
    public double getYpos(){return Ypos;}
    public double setXpos(double xpos) {return this.Xpos = xpos;}
    public double setYpos(double ypos) {return this.Ypos = ypos;}

    private double currentSpeed;

    public int getDirection() {return Direction;}
    public int setDirection(int direction) {return this.Direction = direction;}




    public double getCurrentSpeed(){
        return currentSpeed;
    }
    protected double setCurrentSpeed(double CurrentSpeed){ return this.currentSpeed = CurrentSpeed;}

    @Override
        public void move() {
        //if (getCanMove()) {
            int value = (Direction % 360);
            value = value / 90;
            switch (value) {
                case 0:
                    Xpos += getCurrentSpeed();
                    break;
                case 1:
                    Ypos += getCurrentSpeed();
                    break;
                case 2:
                    Xpos -= getCurrentSpeed();
                    break;
                case 3:
                    Ypos -= getCurrentSpeed();
                    break;

            }
            //updateObservers();
        //}
    }



    @Override
    public void turnleft() {
        Direction += 90;
        Direction = Direction % 360;

    }

    @Override
    public void turnright() {
        Direction -= 90;
        Direction += 360;
        Direction = Direction % 360;


    }
}
