import java.util.List;


public class Factory {

    public static void addSaab(List<Car> lista){
        Saab95 saab = new Saab95();
        lista.add(saab);
    }

    public static void addVolvo(List<Car> lista){
        Volvo240 volvo = new Volvo240();
        lista.add(volvo);

    }

    public static void addScania(List<Car> Lista){
        Scania scania = new Scania();
        Lista.add(scania);
    }

}









