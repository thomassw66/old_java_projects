import java.util.ArrayList;
import java.util.Scanner;


public class Main2 {
	static ArrayList<ArrayList<Integer>> intersections;
	static int [][] connections;
	static int [][] memory;
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		int city = 0;
		while(input.hasNext()){
			int roads = input.nextInt();
			intersections = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < roads; i++){
				int inter = input.nextInt();
				int connectTo = input.nextInt();
				
				while(Math.max(inter, connectTo) >= intersections.size() )
					intersections.add(new ArrayList<Integer>());
				
				intersections.get(inter).add(connectTo);
			}
			connections = new int[intersections.size()][intersections.size()];
			memory = new int[intersections.size()][intersections.size()];
			numPaths();
			System.out.println("matrix for city "+(city++));
			printGrid(connections);
		}
	}
	static void numPaths(){
		for(int i = 0; i < intersections.size(); i++){
			numberPaths(i,i);
			//printGrid(connections);
		}
	}
	public static void numberPaths(int pos, int x){
		if(connections[pos][x] == -1)
			return;
		if(pos != x)
			connections[pos][x]++;
		
		for(int i : intersections.get(x)){
			if(memory[i][x] >= 1){
				fillRow(x);
				return;
			}
			if(i < pos){
				if(connections[i][x] != 0){
					fillRow(x);
				}
				else if(connections[i][i] != -1 && connections[x][x] != -1){
					System.out.println("cheating..."+i + " "+x);
					for(int index = 0; index < connections.length; index++){
						connections[pos][index] += connections[i][index];
					}
					continue;
				}
			}
			memory[i][x] ++;
			numberPaths(pos, i);
			memory[i][x] --;
		
		}
	}
	static void inc(int i, int a){
		if(connections[i][a] != -1)
			connections[i][a]++;
	}
	static void fillRow(int r){
		for(int i = 0; i < connections[r].length; i++){
			connections[r][i] = -1;
		}
	}
	static void printGrid(int [][] a){
		for(int [] b : a)
			printArray(b);
	}
	public static void printArray(int [] a){
		for (int  i : a)
			System.out.print(i+" ");
		System.out.print("\n");
	}
}
