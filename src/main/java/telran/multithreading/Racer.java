package telran.multithreading;

public class Racer extends Thread{
    private Race race;
    private int number;
    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }
    public void run(){
        //TODO
        //Running cycle containing number of iterations from the Race reference as the distance 
        //Each iteration is printing out the number of the thread for game tracing to see game dynamics
        
    }

}