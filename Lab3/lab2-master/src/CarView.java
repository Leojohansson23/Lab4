import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame  /*implements Observable*/ {

    private List<Car> cars;

    public CarView(String framename, List<Car> cars){
        initComponents(framename);
        this.cars = cars;
    }

    /*@Override
    public void update(Observable o, Object arg) {
        if (o instanceof Move) {
            Move move = (Move) o;
            System.out.println("Hejsan");
            updateView(move);

        }
    }*/

    public void updateview() {
        for (Car car : this.cars) {
            int x = (int) Math.round(car.move.getXpos());
            int y = (int) Math.round(car.move.getYpos());
            drawPanel.moveit(this.cars.indexOf(car),x, y);

        }
        drawPanel.repaint();
    }

    private static final int X = 800;
    private static final int Y = 850;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private   JButton addVolvoButton = new JButton("Add Volvo");
    private JButton addSaabButton = new JButton("Add Saab");

    private JButton addScaniaButton = new JButton("Add Scania");

    private JButton removeCarButton = new JButton("Remove Car");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");


    public void addGasButtonListener(ActionListener listener) {
        gasButton.addActionListener(listener);
    }
    public void addBreakButtonListener(ActionListener listener) {brakeButton.addActionListener(listener);}
    public void addturboOnButtonListener(ActionListener listener) {turboOnButton.addActionListener(listener);}
    public void addturboOffButtonListener(ActionListener listener) {turboOffButton.addActionListener(listener);}
    public void addHigherliftBedButtonListener(ActionListener listener) {liftBedButton.addActionListener(listener);}
    public void addLowerLiftBedButtonListener(ActionListener listener) {lowerBedButton.addActionListener(listener);}
    public void addVolvoButtonListener(ActionListener listener) {addVolvoButton.addActionListener(listener);}
    public void addSaabButtonListener(ActionListener listener) {addSaabButton.addActionListener(listener);}
    public void addScaniaButtonListener(ActionListener listener) {addScaniaButton.addActionListener(listener);}
    public void addremoveCarButtonListener(ActionListener listener){removeCarButton.addActionListener(listener);}
    public void addstartButtonListener(ActionListener listener){startButton.addActionListener(listener);}
    public void addstopButtonListener(ActionListener listener){stopButton.addActionListener(listener);}

    // Constructor

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addVolvoButton,6);
        controlPanel.add(addSaabButton,7);
        controlPanel.add(addScaniaButton,8);
        controlPanel.add(removeCarButton,9);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

