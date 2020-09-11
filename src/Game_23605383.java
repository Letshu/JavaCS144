import java.util.ArrayList;
import java.util.Arrays;

import princeton.In;

public class Game_23605383 {
	private static int row ;
	private static int column;
	private static  int noGame;

    public static void main(String[] args) {
        In gameFile = new In(args[0]);
        int outputVersion = Integer.parseInt(args[1]);       
        row= gameFile.readInt();
        column = gameFile.readInt();
        noGame = gameFile.readInt();
        String[][] gameBoard = new String[column][row];
        FillArray(gameBoard);
        gameFile.readLine();
        gameFile.readString();
        int numberWarriows= gameFile.readInt();
        int count =0;
        gameFile.readLine();
        AirWarrior_23605383[] Air = new AirWarrior_23605383[numberWarriows];
        WaterWarrior_23605383[] Water = new WaterWarrior_23605383[numberWarriows];
        StoneWarrior_23605383[] Stone = new StoneWarrior_23605383[numberWarriows];
        FlameWarrior_23605383[] Flame = new FlameWarrior_23605383[numberWarriows];
        ArrayList<Restorer_23605383> restorer = new ArrayList<Restorer_23605383>();
        ArrayList<Potion_23605383> potion = new ArrayList<Potion_23605383>();
        ArrayList<Weapon_23605383> weapon = new ArrayList<Weapon_23605383>();
        int countAir =0;
		int countFlame=0;
		int countWater=0;
		int countStone=0;
		int countPotion;
		int countResteror=0;
		int countWeapon =0;
		int countMagic =0;
        
		while(count < numberWarriows) {
			int PlayerRow = gameFile.readInt();
			int PlayerColumn= gameFile.readInt();
			int id = gameFile.readInt();
			String warriorType = gameFile.readString();
			int age = gameFile.readInt();
			double health = gameFile.readDouble();
			double offensePower= gameFile.readDouble();
			double defenseStrength = gameFile.readDouble();
			int weaponSize = gameFile.readInt();
			String moves = gameFile.readString();
			switch(warriorType.charAt(0)) {
			case 'A':
				String name = "A"+countAir;
				Air[countAir] = new AirWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerRow,PlayerColumn,moves,name);	
				gameBoard[PlayerRow][PlayerColumn] += "A";
				countAir++;
				break;
			case 'W':
				name = "W"+countWater;
				Water[countWater] = new WaterWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerRow,PlayerColumn,moves,name);
				countWater++;
				gameBoard[PlayerRow][PlayerColumn] += "W";
				break;
			case 'S':
				name = "S"+countStone;
				Stone[countStone] = new StoneWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerRow,PlayerColumn,moves,name);
				countStone++;
				gameBoard[PlayerRow][PlayerColumn] += "S";
				break;
			case 'F':
				name = "F"+countFlame;
				Flame[countFlame] = new FlameWarrior_23605383(id,age,health,offensePower,defenseStrength,weaponSize,PlayerRow,PlayerColumn,moves,name);
				countFlame++;
				gameBoard[PlayerRow][PlayerColumn] += "F";
				break;
			}
			count++;
			gameFile.readLine();
		}
		count =0; //count is reset to zero to manage how many variables I use
		String name ="";
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		/*
		 * There will be 5 repetition of the above code to account for 7 pieces in the game
		 */
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		
		count =0; //count is reset to zero to manage how many variables I use
		if(gameFile.hasNextLine()) {
			String type = gameFile.readString();
			if(type.contains("Restorer")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "h"+count;
					int col = gameFile.readInt();
					int row = gameFile.readInt();
					int power = gameFile.readInt();
					restorer.add(new Restorer_23605383(col,row,power,name));
					gameBoard[col][row] += "h";
					gameFile.readLine();
				}
			}
			if(type.contains("Potion")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "p"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					int Type = gameFile.readInt();
					if(Type == 2) {
						int fourth = gameFile.readInt();
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,fourth,name));
					}else {
						gameBoard[col][row] += "p";
						potion.add(new Potion_23605383(col,row,Type,name));
					}
					
					gameFile.readLine();
				}
			}
			
			if(type.contains("Weapon")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					name = "x"+count;
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					double power = gameFile.readDouble();
					gameBoard[col][row] += "x";
					weapon.add(new Weapon_23605383(col,row,power,name));
					gameFile.readLine();
				}
			}
			if(type.contains("Peacemaker")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "h" ;
					gameFile.readLine();
				}
			}
			if(type.contains("Water")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "w" ;
					gameFile.readLine();
				}
			}
			
			if(type.contains("Magic")) {
				count = gameFile.readInt();
				gameFile.readLine();
				for(int i=0;i<count;i++) {
					int col =gameFile.readInt();
					int row = gameFile.readInt();
					gameBoard[col][row] += "c" ;
					gameFile.readLine();
				}
			}
		}
		
		Restorer_23605383[] r = new Restorer_23605383[restorer.size()];
		r = restorer.toArray(r);
		Weapon_23605383[] w = new Weapon_23605383[weapon.size()];
		w= weapon.toArray(w);
		Potion_23605383[] q = new Potion_23605383[potion.size()];
		q = potion.toArray(q);
		



		if (outputVersion == 0) {
			// warrior statistics mode
			System.out.println("I'm in here");
        } 
        else if (outputVersion == 1) {
            // warrior statistics with visualization mode
        	
        }
    }
    
    public static void printBoard(String[][] temp) {
    	for(int i=0;i<temp.length;i++) {
    		for(int j=0;j<temp[i].length;j++) {
    			System.out.print(temp[i][j]);
    		}
    		System.out.println();
    	}
    }
    public static void FillArray(String[][] SC){
        for (int i = 0; i < SC.length; i++){
            Arrays.fill(SC[i], ".");
        }
    }

}