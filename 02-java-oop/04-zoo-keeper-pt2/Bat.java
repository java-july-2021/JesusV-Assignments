public class Bat extends Mammal {

    public Bat(){
        setEnergyLevel(300);
    }
    
    public void fly(){
        System.out.println("SWISSSSSSSH!");
        setEnergyLevel(-50);
    }

    public void eatHumans(){
        System.out.println("Five... or perhaps, six");
        setEnergyLevel(25);
    }

    public void attackTown(){
        System.out.println("Be right there");
        setEnergyLevel(100);
    }
}