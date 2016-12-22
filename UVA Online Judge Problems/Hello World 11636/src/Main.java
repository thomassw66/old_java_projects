import java.util.Scanner;


public class Main {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		
		int CASE = 1;
		
		while(in.hasNext()){
			int n = in.nextInt();
			
			if(n < 0)
				break;
			
			System.out.println("Case " + CASE++ +": " + pastesRequired(n));
		}
	}
	static int pastesRequired(int lines){
		lines --;
		int p = 0;
		while (lines > 0){
			lines >>= 1;
			p++;
		}
		return p;
	}
}
