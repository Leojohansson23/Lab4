import java.util.List;


public class Factory {

    public static Car addSaab(){
        return new Saab95();
    }

    public static Car addVolvo(){
        return new Volvo240();
    }

    public static Car addScania(){
        return new Scania();
    }

}









