import java.lang.*;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double c;
        c = Math.sqrt(Math.pow(legA, 2) + Math.pow(legB, 2));
        return c;
    }
    
    
}