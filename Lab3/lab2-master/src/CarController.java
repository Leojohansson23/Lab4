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


    public CarController(CarView view, CarWorld carworld) {
        this.frame = view;
        this.carworld = carworld;
        initListeners();
    }

    private void initListeners(){
        // TODO: Create more for each component as necessary
        //frame.gasButton.addActionListener(new ActionListener() {
        frame.addGasButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.gas(frame.gasAmount);
            }
        });

        frame.addBreakButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.brake(frame.gasAmount);
            }
        });

        frame.addturboOnButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.turboON();
            }
        });

        frame.addturboOffButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.turboOff();

            }
        });

        frame.addVolvoButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddVolvo();
            }
        });

        frame.addSaabButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddSaab();
            }
        });

        frame.addScaniaButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.AddScania();
            }
        });

        frame.addremoveCarButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.RemoveCar();
            }
        });

        frame.addHigherliftBedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.higherBed();

            }
        });

        frame.addLowerLiftBedButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.lowerBed();

            }
        });

        frame.addstartButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carworld.startAllCars();
            }
        });

        frame.addstopButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    carworld.stopAllCars();
                }
        });
    }
}




