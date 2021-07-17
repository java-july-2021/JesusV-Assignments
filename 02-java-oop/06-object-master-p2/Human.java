public class Human{
    protected int strength, stealth, intelligence, health;

    public Human(){
        this.strength = 3;
        this.stealth = 3;
        this.intelligence =3;
        this.health = 100; 
    }

    public int getStrength(){
        System.out.println(String.format("Strength is: %d", this.strength));
        return strength;
    }

    public int getStealth(){
        System.out.println(String.format("Stealth is: %d", this.stealth));
        return stealth;
    }

    public int getIntelligence() {
        System.out.println(String.format("Your intelligence is: %d", this.intelligence));
        return intelligence;
    }

    public int getHealth(){
        return health;
    }

    public void setStrength(int strength){
        this.strength = strength; 
    }

    public void setStealth(int stealth){
        this.stealth = stealth;
    }

    public void setIntelligence(int intel){
        this.intelligence = intel;
    }

    public void setHealth(int health){
        this.health = (this.health + health);
    }

    public void attack(Human player){
        player.health = (player.health - getStrength());
    }

}