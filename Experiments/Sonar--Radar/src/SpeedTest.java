
public class SpeedTest {

	public static void main(String [] args){
		long b,a;
		
		a = System.nanoTime();
		
		//for(int i = 0; i < 1;i++){}
		System.out.println();
		b = System.nanoTime();
		System.out.println(b - a);
	}
}
