import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int CASE = 1;
		int nodes; 
		while((nodes = in.nextInt()) != 0){
			ArrayList<Integer> points[] = (ArrayList<Integer>[])new ArrayList[nodes];
			int [] memory = new int [nodes];
			for(int i = 0; i < nodes; i ++){
				points[i] = new ArrayList<Integer>();
			}
			int start = in.nextInt() - 1;
			
			int p,q;
			while(true){
				p = in.nextInt(); 
				q = in.nextInt();
				if(p == 0 && q == 0)
					break;
				
				points[p-1].add(q - 1);
			}
			ArrayList<Integer> queue = new ArrayList<Integer>();
			queue.add(start);
			int last = start;
			while(queue.size() > 0){

				//int a = queue.remove(queue.size() - 1);
				int a = queue.remove(0);
				int ncost = memory[a] + 1;
				for(int i : points[a]){
					if(memory[i] < ncost){
						memory[i] = ncost;
						queue.add(i);
					}
				}	
				//Collections.sort(queue);
			}
			int m = -1,mi = -1;
			for(int i = 0; i < memory.length; i++){
				if(memory[i] > m){
					mi = i;
					m = memory[i];
				}
			}
			System.out.printf("Case %d: The longest path from %d has length %d, finishing at %d.%n", CASE++, start+1, m, mi+1);
			System.out.println();
			//Case 3: The longest path from 5 has length 2, finishing at 1.
		}
	}
}