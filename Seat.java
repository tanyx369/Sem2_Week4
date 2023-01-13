import java.util.*;

public class Seat {
	
	boolean available;
	int seat_number;
	String option;
	int num;
	String choice;
	
	// default is false
	private boolean[][] economic = new boolean[15][6];
	boolean[][] first= new boolean[5][4];
	
	public Seat(String str) {
		
		StringTokenizer token = new StringTokenizer(str, " ");
		for(int i = 0 ; i < token.countTokens() ; i++) {
			
		}
		
	}
	
	
	public Seat() {
		
	}
	
	public boolean[][] getEcon() {
		return economic;
	}
	
	public boolean[][] getFirst(){
		return first;
	}
	
	public String getEcon(int x , int i) {
		
		if(economic[x][i] == true) {
			return "FULL";
		}
		else {
			return "EMPTY";
		}
		
	}
	
	public String getFirst(int x , int i) {
		
		if(first[x][i] == true) {
			return "FULL";
		}
		else {
			return "EMPTY";
		}
		
	}
	

	public static void main(String[] args) {
		Seat s1 = new Seat();
		System.out.println(s1.economic[3][2]);

	}

}
