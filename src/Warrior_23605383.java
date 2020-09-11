public class Warrior_23605383 {
	private int ID;
	private int Age;
	private double health;
	private double offensePower;
	private double defenseStrength;
	private int weaponInventory;
	private int PlayerRow;
	private int PlayerColumn;
	private String moves;
	private String name;
	
	Warrior_23605383(){
		/*
		 * Empty constructor for warriors that are not in the game
		 */
	}
	
	Warrior_23605383(int ID,int Age,double health,double offensePower,double defenseStrength,int weaponInventory,int xValue,int yValue,String moves,String name){
		this.ID = ID;
		this.Age=Age;
		this.health=health;
		this.offensePower= offensePower;
		this.defenseStrength= defenseStrength;
		this.weaponInventory = weaponInventory;
		PlayerRow = xValue;
		PlayerColumn= yValue;
		this.moves=moves;
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	public double getOffensePower() {
		return offensePower;
	}
	public void setOffensePower(double offensePower) {
		this.offensePower = offensePower;
	}
	public double getDefenseStrength() {
		return defenseStrength;
	}
	public void setDefenseStrength(double defenseStrength) {
		this.defenseStrength = defenseStrength;
	}
	public int getWeaponInventory() {
		return weaponInventory;
	}
	public void setWeaponInventory(int weaponInventory) {
		this.weaponInventory = weaponInventory;
	}
	public int getPlayerRow() {
		return PlayerRow;
	}
	public void setPlayerRow(int xValue) {
		PlayerRow = xValue;
	}
	public int getPlayerColumn() {
		return PlayerColumn;
	}
	public void setPlayerColumn(int yValue) {
		PlayerColumn = yValue;
	}
	public String getMoves() {
		return moves;
	}
	public void setMoves(String moves) {
		this.moves = moves;
	}
	public String getName() {
		return name;
	}
	public void rightMove(String[][] temp,String s){
		for(int i = 0;i<temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				if(temp[i][j].contains(s)){
					if(j== temp[0].length-1){
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i][0] += s;
					}else{
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i][j+1] += s;
					}
				}
			}
		}
	}

	public void leftMove(String[][] temp,String s){
		for(int i = 0;i<temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				if(temp[i][j].contains(s)){
					if(j>0){
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i][j-1]+=s;
					}else {
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i][temp[0].length-1]+=s;
					}
				}
			}
		}
	}
	public void upMove(String[][] temp,String s){
		for(int i=0;i < temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				if(temp[i][j].contains(s)){
					if(i>0){
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i-1][j] += s;
					}else{
						temp[i][j] = temp[i][j].replace(s,"");
						temp[temp[0].length-1][j] += s;
					}
				}
			}
		}
	}
	public void downMove(String[][] temp,String s){
		for(int i=0;i < temp.length;i++){
			for(int j=0;j<temp[i].length;j++){
				if(temp[i][j].contains(s)){
					if(i<temp[0].length){
						temp[i][j] = temp[i][j].replace(s,"");
						temp[i+1][j] += s;
					}else{
						temp[i][j] = temp[i][j].replace(s,"");
						temp[0][j] += s;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return name;
	}



	
}

