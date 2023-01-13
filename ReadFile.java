import java.io.*;
import java.util.*;

public class ReadFile
{
	static String name;
	static int total_char = 0;
	static int total_word = 0;
	static int total_line = 0;
	
	public static void ask() {
		Scanner ask = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		name = ask.nextLine() + ".txt";
		ask.close();
	}
	
	public static void analyze() throws FileNotFoundException  {
		FileReader file = new FileReader(name);
		FileReader file2 = new FileReader(name); // Use two filereader
		
		// 一个FileReader 只能同时和一个scanner build connection 罢了
		
		/*
		// hasNext()  是算你还能用多少次next(), 一用了过后就会扣掉, 如果没有用到就不会被扣掉
 		while(scan.hasNext()) {
 			total_word++;
			scan.next();
			
		}
		*/
		
		
		Scanner scan_word = new Scanner(file);
		while(scan_word.hasNext()) {
			
			String data = scan_word.next();
		    total_char += data.length();
			total_word ++;
			
		}
		scan_word.close();
		
	
		Scanner scan_line = new Scanner(file2);
		while(scan_line.hasNextLine()) {
			scan_line.nextLine();
			total_line ++ ;
		}
		scan_line.close();
		
		
		
		
		System.out.println("Total chararters: " + total_char );
		System.out.println("Total words: " + total_word);
		System.out.println("Total lines: " + total_line);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ask();
		analyze();
	}
	

    
}


/*
Scanner scan_char = new Scanner(file);
//scan_char.useDelimiter("");
while(scan_char.hasNext()) {
	System.out.println("o");
	total_char += scan_char.next().length();
}
scan_char.close();
*/

