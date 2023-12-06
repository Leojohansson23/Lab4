import java.awt.*;

public class Scania extends Truck  {

    public Scania(){
        super(2,300,Color.pink, "src.Scania");
        stopEngine();
        scaniacarrier.setCanMove(true);

    }

    ScaniaCarrier scaniacarrier = new ScaniaCarrier();


    // Fråga TA om detta är nödvändigt eller en bra idé !
    public void CarrierHigher() {
        if (move.getCurrentSpeed() == 0) {
            scaniacarrier.carrierHigher();
        }
    }
    public void CarrierLower(){
        if(move.getCurrentSpeed() == 0) {
            scaniacarrier.carrierLower();
        }
    }

    /*@Override
    public boolean getCanMove() {
        if (scaniacarrier.getangle() > scaniacarrier.getMinAngle()) {

            return false;
        }
        return true;
    }*/


}