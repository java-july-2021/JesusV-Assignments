public class ClassTester {
    public static void main(String[] args){
        Ninja robin = new Ninja();
        Wizard gandoff = new Wizard();
        Samurai jack = new Samurai();
        Human jesus = new Human();

        robin.runAway(robin);

        gandoff.fireball(jack);

        slicesMcgee.deathBlow(gandoff);

        System.out.println(gandoff.getHealth());

        System.out.println(Samurai.howMany());

    }
    
}