
public class Weapon_23605383 {
	private int cols;
	private int rows;
	private double power;
	private String name;
	
	public Weapon_23605383() {
		//This is just an empty constructor for when there's no warrior initialized yet
	}

	public Weapon_23605383(int cols, int rows, double power,String name) {
		this.cols = cols;
		this.rows = rows;
		this.power = power;
		this.name=name;
	}

	public int getCols() {
		return cols;
	}

	public int getRows() {
		return rows;
	}

	public double getPower() {
		return power;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
