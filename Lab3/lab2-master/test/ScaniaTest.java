import junit.framework.TestCase;
import org.junit.Test;

public class ScaniaTest extends TestCase {


    @Test
    public void testhigher (){
        Scania truck = new Scania();
        truck.getCanMove();
        truck.CarrierHigher();
        assertEquals(10,truck.getangle());

    }

    @Test
    public void testlower(){
        Scania truck = new Scania();
        truck.CarrierHigher();
        truck.CarrierHigher();
        assertEquals(20,truck.getangle());


    }

    @Test
    public void testscania(){
        Scania test = new Scania();
        test.carrierHigher();
        test.carrierLower();
        test.carrierLower();
        test.carrierLower();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.carrierHigher();
        test.getCanMove();
        assertEquals(false,test.getCanMove());


    }
}