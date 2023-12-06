public class Cartransportcarrier implements Tilting {

    private boolean carrierPos;
    
    public boolean getCarrierpos(){
        return carrierPos;
    }
    @Override
    public void carrierHigher() {
            carrierPos = false;
    }

    @Override
    public void carrierLower() {
            carrierPos = true;
    }
}
