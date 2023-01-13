import java.io.*;
import java.util.*;

public class WriteFile
{
	
	static String name;
	static File file;
	static FileWriter f1;
	static PrintWriter write;
	
    public static void ask() {
    	Scanner ask = new Scanner(System.in);
    	System.out.println("Enter your file name: ");
    	name = ask.nextLine() + ".txt";
    	ask.close();
    	
    	
    }
    
    public static void createFile() throws IOException{
    	file = new File(name);
    	
    }
    
    public static void writeFile() throws IOException {
    	f1 = new FileWriter(file);
    	write = new PrintWriter(f1);
    	write.println("Hello, My first program in File ");
    	
    	write.close();
    	f1.close();
    }
    
    public static void readFile() throws IOException{
    	Scanner scan = new Scanner(file);
    	System.out.println(scan.nextLine());
    }
    
    public static void main(String[] args) throws IOException{
    	ask();
    	createFile();
    	writeFile();
    	readFile();
    	
    }
    
}
