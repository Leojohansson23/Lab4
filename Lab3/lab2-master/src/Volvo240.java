import java.awt.*;

public class Volvo240 extends Car{

    public Volvo240(){
        super(4,100, Color.black, "src.Volvo240");
        stopEngine();
        setTrimFactor(1);

    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * getTrimFactor();
    }

}
