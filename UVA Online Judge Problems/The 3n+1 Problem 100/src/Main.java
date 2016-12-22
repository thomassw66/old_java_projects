import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int low = in.nextInt();
			int high = in.nextInt();
			
			
			
			
			
			in.nextLine();
		}
	}
	public int threenp1(int n){
		int max = n;
		while(n != 1){
			//even
			if((n&1) == 0){
				n = n>>1;
			}
			//odd
			else{
				n = ((n<<1) + n) + 1;
				if(n > max)
					max = n;
			}
		}
		return max;
	}
}
