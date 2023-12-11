import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarWorld {

    //privafte T Car;
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed

    Factory fact = new Factory();
    CarController CarC;
    ArrayList<Car> cars = new ArrayList<>();


    public static void main(String[] args) {

        // Instance of this class
        CarWorld cw = new CarWorld();
        cw.cars.add(new Volvo240());
        cw.cars.add(new Saab95());
        cw.cars.add(new Scania());
        cw.frame = new CarView("CarSim 1.0",cw.cars);
        cw.CarC = new CarController(cw.frame, cw.cars, cw);

        //Saab95CarController.frame = new CarView("CarSim 1.0",Saab95CarController);
        //Saab95CarController.timer.start();

        // Start a new view and send a reference of self

        // Start the timer
        cw.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                if (car instanceof Scania) {
                    if (((Scania) car).scaniacarrier.getCanMove())
                        car.move.move();
                } else if (car instanceof Cartransport) {
                    if (((Cartransport) car).Cartransportcarrier.getCarrierpos()) {
                        car.move.move();
                    }
                } else {
                    car.move.move();
                }

                car.keepInFrame();

            }

            frame.updateview();

        }
    }
    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            if (car instanceof Scania) {
                if (((Scania) car).scaniacarrier.getCanMove()) {
                    car.gas(gas);
                }
            }
            else if (car instanceof Cartransport) {
                if (((Cartransport) car).Cartransportcarrier.getCarrierpos()) {
                    car.gas(gas);
                }
            } else {
                car.gas(gas);
            }

        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car: cars) {
            car.brake(brake);

        }
    }

    void turboON(){
        for (Car car: cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOn();

            }
        }
    }
    void turboOff(){
        for (Car car: cars) {
            if(car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void AddVolvo(){
        if(cars.size() < 10){
            cars.add(fact.addVolvo());
            frame.drawPanel.addVolvoImage();
            //volvo.addObserver(frame);
        }
    }

    void AddSaab(){
        if(cars.size() < 10){
            cars.add(fact.addSaab());
            frame.drawPanel.addSaabImage();
            //saab.addObserver(frame);
        }
    }

    void AddScania(){
        if(cars.size() < 10){
            cars.add(fact.addScania());
            frame.drawPanel.addScaniaImage();
            //scania.addObserver(frame);
        }
    }


    void RemoveCar(){
        if (cars.size() > 0) {
            frame.drawPanel.removeImage();

            cars.remove(cars.size()-1);

        }

    }


    void lowerBed(){
        for (Car car: cars) {
            if(car instanceof Scania)
            {
                ((Scania) car).CarrierLower();
            }
        }
    }


    void higherBed(){
        for (Car car: cars) {
            if(car instanceof Scania)
            {

                ((Scania) car).CarrierHigher();
            }
        }


    }

    void stopAllCars(){
        for (Car car: cars){
            while (car.move.getCurrentSpeed() > 0){
                car.brake(1);
            }
        }
    }

    void startAllCars() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                if (((Scania) car).scaniacarrier.getCanMove()) {
                    while (car.move.getCurrentSpeed() < 0.1) {
                        car.gas(0.5);
                    }
                }
            } else if (car instanceof Cartransport) {
                if (((Cartransport) car).Cartransportcarrier.getCarrierpos()) {
                    while (car.move.getCurrentSpeed() < 0.1) {
                        car.gas(0.5);

                    }
                }
            } else {
                while (car.move.getCurrentSpeed() < 0.1) {
                    car.gas(0.5);
                }
            }
        }
    }
}




