

import java.awt.*;
public abstract class Car{

    public Car(int nrDoors, double enginePower, Color color,String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;

    }

    Move move = new Move();
        private boolean onTruck = false;

        private final int nrDoors; // Number of doors on the car
        private double enginePower; // Engine power of the car
        private Color color; // Color of the car
        private final String modelName; // The car model name
        public Color getColor(){return color;}
        public String getModelName(){return modelName;}
        public void setColor(Color clr){color = clr;}
        public int getNrDoors(){return nrDoors;}
        public double setEnginePower(double power){return this.enginePower = power;}

        public double getEnginePower(){
            return enginePower;
        }
        public void startEngine(){move.setCurrentSpeed(0.1);}
        public void stopEngine(){move.setCurrentSpeed(0);}

        public boolean turboOn;
        private double trimFactor;
        public double setTrimFactor(double trim){return this.trimFactor = trim;}
        public double getTrimFactor(){return trimFactor;}

    public double speedFactor(){
        return enginePower * 0.01;

    }

    private void incrementSpeed(double amount){
        move.setCurrentSpeed(Math.min(move.getCurrentSpeed() + speedFactor() * amount,enginePower));
    }

    private void decrementSpeed(double amount){
        move.setCurrentSpeed(Math.max(move.getCurrentSpeed() - speedFactor() * amount,0));
    }

    public void gas(double amount){
        if (amount >= 0  && amount <= 1) {
            incrementSpeed(amount);

        }
    }

    public void brake(double amount) {
        if (amount >= 0  && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /*public boolean getCanMove(){return canMove;}

    public boolean setCanMove(boolean can){return this.canMove = can;}

    @Override
    public void move() {
        if (getCanMove()) {
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
        }

    }*/

    /*@Override
    public void turnleft() {
            Direction += 90;
            Direction = Direction % 360;

    }

    @Override
    public void turnright() {
            Direction -= 90;
            Direction += 360;
            Direction = Direction % 360;

    }*/

    public void setOnTruck(boolean onTruck) {
        this.onTruck = onTruck;
    }

    public boolean isOnTruck() {
        return onTruck;
    }
}
