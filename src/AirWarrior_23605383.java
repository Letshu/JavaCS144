public class AirWarrior_23605383 extends Warrior_23605383 implements WarriorTypeInterface_23605383 {

    public AirWarrior_23605383() {
        super();
    }
    public AirWarrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int Xvalue,int Yvalue,String moves,String name) {
    	super(ID,Age,health,offensePower,defenseStrength,weaponInventory,Xvalue,Yvalue,moves,name);
    }

    public void performSpecialAbility() {
    }

    public void specialAbilityCompleted() {
    }
//    public String toString() {
//    	return xValue+" "+yValue+ " "+ ID+" "+health+" "+ offensePower+" "+defenseStrength+" "+weaponInventory; 
//    }
}