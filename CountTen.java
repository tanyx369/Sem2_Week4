import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CountTen
{
	
	// static File f1;   File class 只是用来create 和 access file ，但不能wrtie
	static File file;
	static FileWriter f1;  // File writer 用来write , 
	static PrintWriter write;
	
	public static void createFile() throws IOException {
		file = new File("Count.txt");  // Create file 的时候, 不会有冲突, 不会有exception
		f1 = new FileWriter(file);
		write = new PrintWriter(f1);   // 最初的时候 , file f1 还没有create , 所以 new PrintWriter() 里面的 input 会出问题 , 所以throws Input/Output Exception
 		write.println("10 3 4 5 10 9 8 3 10 8");
 		
 		write.close();   // PrintWriter 一定要close
	}
	
	public static void analyze() throws FileNotFoundException {
		Scanner scan = new Scanner(file); // 在最初的时候, file 还没有create 出, 没有找到file所以有冲突, 会有exception
		int count = 0;
		while(scan.hasNext()) {
			if(scan.next().equals("10")) {
				count++;
			}
			else {
				continue;
			}
		}
		
		System.out.println("Total occurance of 10: " + count);
		scan.close();
	
	}
	
	
	public static void main(String[] args) throws IOException , FileNotFoundException  {
		createFile();
		analyze();
	}


}
