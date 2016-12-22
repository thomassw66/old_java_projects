import java.util.Arrays;
import java.util.Random;


public class Test {

	public static void main(String [] args){
		Random r = new Random();
		
		int [][] test = new int[r.nextInt(30000)][r.nextInt(30000)];
		for(int i = 0;i < test.length; i++){
			for(int j = 0; j < test[0].length; j++){
				test[i][j] = r.nextInt(300);
			}
		}
		
		long s = System.currentTimeMillis();
		//int i = FirstTry.leastCostTo(0, 0, test.length, test[0].length, test);
		long e = System.currentTimeMillis();
		
		long firsttry = e - s;
		
		long s1 = System.currentTimeMillis();
		int i1 = NavigableGraphAlgorithm.navigate(0, 0, test.length - 1, test[0].length -1, test);
		long e1 = System.currentTimeMillis();
		
		long other = e - s;
		
		System.out.println("FirstTry: " + firsttry + " ms");
		System.out.println("NavigableGraphAlgorithm : " + firsttry + " ms ; returned: " + i1);
	}
}
