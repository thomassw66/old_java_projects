import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		long i = input.nextLong();
		input.nextLine();
		while(i != 0){
			double a = Math.sqrt(i);
			long b = (long)a;
			double diff = a - b;
			if(diff == 0){
				System.out.println("yes");
			}else{
				System.out.println("no");
			}
			i = input.nextLong();
			input.nextLine();
		}
	}
}
