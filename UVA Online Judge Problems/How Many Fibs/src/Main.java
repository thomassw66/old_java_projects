import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	static ArrayList<BigInteger> fibs = new ArrayList<BigInteger>();
	
	public static void main(String [] args){
		fibs.add(BigInteger.ONE);
		fibs.add(BigInteger.valueOf(2));
		
		Scanner input = new Scanner (System.in);
		BigInteger low = input.nextBigInteger();
		BigInteger high  = input.nextBigInteger();
		input.nextLine();
		while(!low.equals(BigInteger.ZERO)|| !high.equals(BigInteger.ZERO)){
			
			buildUpTo(high);
			int i = fibsBetween(low,high);
			
			System.out.println(i);
			
			low = input.nextBigInteger();
			high  = input.nextBigInteger();
			input.nextLine();
		}
		input.close();
	}
	static void buildUpTo(BigInteger limit){
		while(fibs.get(fibs.size()-1).compareTo(limit) <= 0){
			int s = fibs.size();
			fibs.add(fibs.get(s-1).add(fibs.get(s-2)));
		}
	}
	static int fibsBetween(BigInteger low, BigInteger high){
		int i = 0;
		BigInteger b = fibs.get(0);
		
		while(b.compareTo(low) < 0){
			i++;
			b = fibs.get(i);
		}
		int between = 0;
		while(b.compareTo(high) <= 0 ){
			between++;
			i++;
			b = fibs.get(i);
		}
		return between;
	}
}
