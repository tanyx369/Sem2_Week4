import java.util.*;
import java.io.*;
import java.lang.Object;

enum command{
	HELP, BOOK, SHOW_SEAT;
	
}

public class Airline_Seating
{
	

	String option;
	int num;
	String choice;
	
	Seat seat = new Seat();
	String[] label = {"A" , "B" , "C" , "D" , "E" , "F" ,"G" };
	boolean[][] econ = seat.getEcon();
	boolean[][] first = seat.getFirst();
	
	public Airline_Seating() {
		
	}

	
	public Airline_Seating(String option, int num , String choice) {
		this.option = option;
		this.num = num;
		this.choice = choice;
	}
	
	

	public void ask() {
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println("Choose your seat type:");
		option = scan.nextLine();
		
		askpass();
		
		// Because put print preference here , even when the error , it's still print out one more time (original & when error)
	}
	
	public void askpass() {
		
		Scanner scan2 = new Scanner(System.in);
	
		
		if(option.equals("economic")) {
			System.out.println("Number of passagers (1-3) : ");
			num = scan2.nextInt();
			if (num > 3 || num < 1) {
				System.out.println("Not within the range !");
				askpass();
			}
		}
		else if(option.equals("first")) {
			System.out.println("Number of passagers (1-2) : ");
			num = scan2.nextInt();
			if (num > 2 || num < 1) {
				System.out.println("Not within the range !");
				askpass();
			}
		}
		else {
			System.out.println("Not available option ! ");
			ask();
		}
	}
	
	public void askPrefer() {
		
		Scanner scan3 = new Scanner(System.in);
		
		System.out.println("What's your preference: ");
		choice = scan3.nextLine();
		if (!choice.equals("window") && !choice.equals("aisle")) {
			System.out.println("Not an available option !");
			askPrefer();
		}
	}
	
	
	public void printSeat() {
		
		String econseat = "";
		String firstseat = "";
	
		
		if(option.equals("economic")) {
			
			for(int x = 0 ; x < econ.length ; x++) {
				for(int y = 0 ; y < econ[x].length ; y++) {
					if(econ[x][y] == false) {
						econseat += " " + (x+1) + label[y] + "| ";
					}
					else {
						econseat += "N/A";
					}
					
				}
				System.out.println("W  " + econseat + "  W\n");
				econseat = "";
			}
			
		}
		else if(option.equals("first")) {
			
			for(int x = 0 ; x < first.length ; x++) {
				for(int y = 0 ; y < first[x].length ; y++) {
					if(first[x][y] == false) {
						firstseat += (x+1) + label[y] + "| ";
					}
					else {
						firstseat += "N/A ";
					}
					
				}
				System.out.println("W  " + firstseat + "  W");
				firstseat = "";
			}
			
		}
		
	}
	
	public void add() throws StringIndexOutOfBoundsException {
		
		Scanner scan4 = new Scanner(System.in);
		
		System.out.println("Choose your seat: ");
		String choose = scan4.nextLine();
		//seat = new Seat(choose);
		
		Scanner scan_choose = new Scanner(choose);
		
		String seat_num = "";
		String seat_place = "";
		
		int x = 0 ;
		boolean word_status = true;
		
		
		if(! Character.isDigit(choose.charAt(0)) && ! Character.isAlphabetic(choose.charAt(1))) {
			word_status = false;
		}
		else {

			scan_choose.useDelimiter("");
			
			
			
			while(scan_choose.hasNext()) {
				
				String next = scan_choose.next();
				
				if(Character.isDigit(choose.charAt(x))){
					seat_num += next;
				}
				else if (Character.isAlphabetic(choose.charAt(x))) {
					seat_place += next;
				}
				x++;
			
			}
		}
		
		
		/*
		scan_choose.useDelimiter("");
		
	
		
		while(scan_choose.hasNext()) {
			
			String next = scan_choose.next();
			
			if(Character.isDigit(choose.charAt(x))){
				seat_num += next;
			}
			else if (Character.isAlphabetic(choose.charAt(x))) {
				seat_place += next;
			}
			x++;
		
		}
		*/
		
		int num = Integer.parseInt(seat_num);
		
		if(word_status) {
			
			if(option.equals("economic")) {
				//int index_2 = ArrayUtils.indexOf(econ , char); One method
				if(num < 1 || num > 15) {
					System.out.println("Out of selection range ! Please try again.");
				}
				else {
					
					// Get index for second 
					int index_2 = 0;
					for(int i = 0 ; i < label.length ; i++) {
						if(seat_place.equals(label[i])) {
							index_2 = i;
						}
					}
					if(econ[num - 1][index_2] == false) {
						this.econ[num - 1][index_2] = true;
					}
					
				}
				
				
	
			}
			else if(option.equals("first")) {
				if(num < 1 || num > 5) {
					System.out.println("Out of selection range ! Please try again.");
				}
				else {
					
					// Get index for second 
					int index_2 = 0;
					for(int i = 0 ; i < label.length ; i++) {
						if(seat_place.equals(label[i])) {
							index_2 = i;
						}
					}
					if(this.first[num - 1][index_2] == false) {
						this.first[num - 1][index_2] = true;
					}
					
				}
			}
			
			
		}
		else {
			System.out.println("Not available option !");
			add();
		}
		

		
		
	}
	
	public void run() {
		
		Scanner scan5 = new Scanner(System.in);
		
		boolean status = true;
		while(status) {
			ask();
			askPrefer();
			printSeat();
			add();
			System.out.println("Do you want to book again , (Y)Yes / (N)No");
			String ans = scan5.nextLine();
			if(ans.equals("N")) {
				status = false;
			}
			else {
				continue;
			}
		}
		
	
	}
 
	//先问,然后show seat 的availability 
	
	
	public static void main(String[] args) {
		
		Airline_Seating a1 = new Airline_Seating();
		a1.run();
		
	}
}
