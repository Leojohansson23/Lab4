public interface Observable {
    public void setChanged(boolean a);
    public void notifyObservers(int x, int y);
}
