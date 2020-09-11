
public class Restorer_23605383 {
	private final int PlayerColumn;
	private final int PlayerRow;
	private final double Benefit;
	private final String name;
	
	Restorer_23605383(int PlayerColumn,int PlayerRow,double Benefit,String name){
		this.PlayerColumn = PlayerColumn;
		this.PlayerRow= PlayerRow;
		this.Benefit= Benefit;
		this.name = name;
	}

	public double getBenefit() {
		return Benefit;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
