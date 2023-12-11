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

public class CarController {


// This actionListener is for the gas button only
    CarWorld carworld;
    CarView frame;
    private List<Car> cars;


    public CarController(CarView view, ArrayList<Car> listofcars, CarWorld carworld) {
        this.frame = view;
        this.cars = listofcars;
        this.carworld = carworld;
        initListeners();
    }

    private void initListeners(){
        // TODO: Create more for each component as necessary
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                carworld.gas(frame.gasAmount);

                System.out.println("Hej");
               // }

            }

        });



        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.brake(frame.gasAmount);
            }
        });


        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.turboON();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.turboOff();

            }
        });

        frame.AddVolvoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddVolvo();
            }
        });

        frame.AddSaabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddSaab();
            }
        });

        frame.AddScaniaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddScania();
            }
        });

        frame.RemoveCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.RemoveCar();
            }
        });


        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.higherBed();

            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.lowerBed();

            }
        });

        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.startAllCars();
            }
        });


    frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.stopAllCars();
            }
        });
    }
}




