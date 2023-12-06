
import java.awt.*;
import java.util.ArrayList;

public class Cartransport extends Truck {

    Cartransportcarrier Cartransportcarrier = new Cartransportcarrier();

    private ArrayList<Car> ramparraylist = new ArrayList<>();

    public ArrayList<Car> getRamparraylist() {
        return ramparraylist;
    }



    public Cartransport(){
        super(2,250,Color.gray, "src.Cartransport");
        stopEngine();
        move.setCanMove(true);


    }

    public boolean getCanMove() {
        if (Cartransportcarrier.getCarrierpos()){
            return false;
        }
        return true;
    }


    public void addcar(Car smallcar) {
        if (isOnTruck() == false) {
            if (Math.abs(smallcar.move.getXpos() - this.move.getXpos()) <= 0.5 && Math.abs(this.move.getYpos() - this.move.getYpos()) <= 0.5)
                if (Cartransportcarrier.getCarrierpos() && ramparraylist.size() <= 8) {
                    smallcar.move.setXpos(this.move.getXpos());
                    smallcar.move.setYpos(this.move.getYpos());
                    if (smallcar instanceof Truck) {

                    } else {
                        ramparraylist.add(smallcar);
                        setOnTruck(true);
                    }
                }
        }
    }

    public int getcarsoncarrier (){
        return ramparraylist.size();
    }

    public void removecar(){
        if (Cartransportcarrier.getCarrierpos()){
            ramparraylist.get(ramparraylist.size() - 1).move.setXpos(this.move.getXpos() + 0.2);
            ramparraylist.get(ramparraylist.size() - 1).move.setYpos(this.move.getYpos() + 0.2);

            ramparraylist.get(ramparraylist.size()-1).setOnTruck(false);
            ramparraylist.remove(ramparraylist.size() - 1);
        }
    }






    public void move() {
        move.move();
        for(Car car : ramparraylist){
                car.move.move();
        }
    }


}





