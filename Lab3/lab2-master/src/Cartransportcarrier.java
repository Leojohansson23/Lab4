public class Cartransportcarrier implements Tilting {

    private boolean carrierPos;
    
    public boolean getCarrierpos(){
        return carrierPos;
    }

    private boolean canMove;

    public boolean getCanMove(){return canMove;}

    public boolean setCanMove(boolean can){return this.canMove = can;}

    @Override
    public void carrierHigher() {
            carrierPos = false;
    }

    @Override
    public void carrierLower() {
            carrierPos = true;
    }
}
