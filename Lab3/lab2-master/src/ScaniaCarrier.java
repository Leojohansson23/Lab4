public class ScaniaCarrier implements Tilting {


    private int angle = 0;
    private  int maxAngle = 70;

    private int minAngle = 0;


    public int getangle(){
        return angle;

    }

    public int getMinAngle(){
        return minAngle;
    }
    public void setangle(int degree){
        angle = degree;

    }

    public void carrierHigher() {
            if ((getangle() + 10) <= maxAngle) {
                setangle(getangle() + 10);
            }
            else {setangle(maxAngle);

            }
    }

    public void carrierLower() {
            if ((getangle() - 10) > minAngle) {
                setangle(getangle() - 10);

            }
            else {setangle(minAngle);
            }

        }
}
