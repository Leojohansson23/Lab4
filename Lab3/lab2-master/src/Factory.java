public class Factory {

    static CarController cc = new CarController();
    public static void addSaab(){

    }

    public static void addVolvo(){
        Volvo240 volvo = new Volvo240();
        cc.cars.add(volvo);
        cc.frame.drawPanel.addVolvoImage();
    }

    //public void static addScania(){

    //}
}









