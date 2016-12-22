import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class NQueens {
	static int SIZE;
	static char [][] board;
	static int [][] attacked;
	//different ways queens can move
	static int delta[][] = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1}, {-1, 1}, {1,-1}, {1,1}};
	
	static int solutions = 0;
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		SIZE = in.nextInt();
		in.close();
		attacked = new int[SIZE][SIZE];
		board = new char[SIZE][SIZE];
		// just bad for runtime
		/*
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board.length; j++){
				board[i][j] = ' ';
			}
		}*/
		depthFirstSearch(0);
		System.out.print(solutions + " solutions found\n");
	}
	//limited depth first search algorithmv
	static void depthFirstSearch(int x){
		//if we successfullyfill board with N queens
		if(x >= board.length){
			print(board);
			System.out.println("------------------------");
			//print(attacked);
			//System.exit(0);
			solutions++;
			return;
		}
		int i = 0;
		while(i < board.length){
			// added to skip bad collums making more efficient
			while(attacked[x][i] > 0){
				i++;
				if(i >= board.length)
					return;
			}
			board[x][i] = 'Q';
			addQ(x,i,1);

			//*********************************************
			
			//original program included this...
			//checks all the posistions of the queens to make sure none are attacked
			
			//reduntant because of the while statement above
			//if no queen is attacking this spot then then this will not attack anything else
			
			//if we are not already doomed!
			/*if(!constraintBroken()){
				depthFirstSearch(x + 1);
			}*/
			
			//*********************************************
			depthFirstSearch(x + 1);

			//clean up for other iterations
			board[x][i] = ' ';
			addQ(x, i, -1);
			i++;
		}
	}
	// not used...
	/*
	static boolean constraintBroken(){
		for(int a : pos){
			int x = a / board.length;
			int y = a % board.length;
			
			if(attacked[x][y] > 0){
				//System.out.println(x + " " + y + " " + attacked[x][y]);
				return true;
			}
				
		}
		return false;
	}*/
	private static void print(char[][] board2) {
		for(char [] b : board2){
			System.out.println(Arrays.toString(b));
		}
	}
	static void addQ(int x, int y, int n){
		for(int a[] : delta){
			int nx = x;
			int ny = y;
			while(inBounds(nx += a[0], ny += a[1])){
				attacked[nx][ny] += n;
			}
		}
	}
	static boolean inBounds(int x,int y){
		return (x < board.length && x >= 0) && (y < board[x].length && y >= 0);
	}
	static public void print(int[][] attacked2){
		for(int [] b : attacked2){
			System.out.println(Arrays.toString(b));
		}
	}
}
