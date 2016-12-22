import java.math.BigInteger;
import java.util.ArrayList;


public class FibTest {
	static ArrayList<TBN> fibs = new ArrayList<TBN>();
	public static void main(String [] args){
		fibs.add(TBN.valueof(1));
		fibs.add(TBN.valueof(1));
		
		for(int i = 1; i < 500; i++){
			System.out.println(fib(i));
		}
	}
	static TBN fib(int f){
		TBN prev,pen;
		int ind;
		while((ind = fibs.size()) < f){
			pen = fibs.get(ind - 2);
			prev = fibs.get( ind - 1);
			
			fibs.add(TBN.add(prev, pen));
		}
		return fibs.get(f-1);
	}
}
