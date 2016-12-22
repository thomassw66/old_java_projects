import java.util.Arrays;
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner input = new Scanner (System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		input.nextLine();
		
		while(m != 0){
			char [][] map = new char[m][];
			int [][] values = new int [m][n];
			
			for(int i = 0; i < m; i++){
				map[i] = input.nextLine().toCharArray();
			}
			int marker = 0;
			for(int i = 0 ; i < m ; i++){
				for(int j = 0; j < n; j++){
					//System.out.println(i +":"+j);
					if(map[i][j] == '@' && values[i][j] == 0){
						marker++;
						markdeposit(i,j,marker,values,map);
						//System.out.println(i + " " + j+" marker="+marker);
					}
				}
			}
			System.out.println(marker);
			/*for(int i = 0; i < map.length; i++)
				System.out.println(Arrays.toString(map[i]));
			for(int i = 0; i < values.length; i++)
				System.out.println(Arrays.toString(values[i]));*/
			
			m = input.nextInt();
			n = input.nextInt();
			input.nextLine();
		}
	}
	public static void markdeposit(int line,int col, int marker,int value[][] , char [][] map){
		if((line < map.length && line >= 0)&&(col < map[line].length && col >= 0)){
			if(map[line][col] == '@' && value[line][col] == 0){
				value[line][col] = marker;
				
				//System.out.println("marked ["+line+"]["+col+"] = "+ marker);
				
				int colr = col + 1;
				int coll = col - 1;
				int lineu = line - 1;
				int lined = line + 1;
				
				markdeposit(line,colr,marker,value,map);
				markdeposit(lineu,colr,marker,value,map);
				markdeposit(lined,colr,marker,value,map);
				markdeposit(line,coll,marker,value,map);
				markdeposit(lineu,coll,marker,value,map);
				markdeposit(lined,coll,marker,value,map);
				markdeposit(lineu,col,marker,value,map);
				markdeposit(lined,col,marker,value,map);
			}
		}	
	}
}
