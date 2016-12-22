import java.math.BigInteger;
import java.util.Scanner;


public class Main {
	//this was soooooooo easy!
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long n = in.nextLong();
			System.out.println(n+"!");
			
			BigInteger fact = BigInteger.ONE;
			for(long i = 2; i <= n; i ++){
				fact = fact.multiply(BigInteger.valueOf(i));
			}
			System.out.println(fact);
			
		}
	}
}
