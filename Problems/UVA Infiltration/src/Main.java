import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner input = new Scanner(System.in);

		
		while(input.hasNext()){		
			int N =  input.nextInt();
			input.nextLine();
			System.out.println();
			char [][] cells = new char[N][N];
			boolean [] control = new boolean[N];
			for(int i = 0; i < N; i++){
				cells[i] = input.nextLine().toCharArray();
				System.out.println(Arrays.toString(cells[i]));
			}
			System.out.println();
			int mxspot = -1;
			int mxcount = 0;
			for(int i = 0; i < N; i++){
				
				int count = 0;
				for(int j = 0; j < N; j++){
						if(cells[j][i] == '0')
							count ++;
				}
				if(count > mxcount){
					mxcount = count;
					mxspot = i;
				}
			}
			System.out.println(mxspot);
		}
		
		input.close();
	}
}
