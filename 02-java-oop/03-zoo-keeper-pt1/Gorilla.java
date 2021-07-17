public class Gorilla extends Mammal{
    public Gorilla(){
        setEnergyLevel(100);
    }

    public void throwSomething(){
        System.out.println("Gorilla has thrown poo at you!")
        setEnergyLevel(-5);
    }

    public void eatBananas(){
        System.out.println("We should eat like Gorillas too!")
        setEnergyLevel(+10);
    }

    public void climb(){
        System.out.println("Gorilla doesn't do any cardio, but he's trying")
        setEnergyLevel(-10);
    }
}