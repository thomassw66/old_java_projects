import java.util.ArrayList;


public class DjihkstrasAlgorithm {

	
	static int d[];
	static int p[];
	
	public static void dijkstra(ArrayList [] al,ArrayList [] aw, int start){
		 
		int M = al.length;
		d = new int[M];
		p = new int[M];
		
		boolean S[] = new boolean[M+1];
		for(int i = 0; i < M; i ++){
			S[i] = false;
			d[i] = Integer.MAX_VALUE;
			p[i] = -1;
		}
		
		S[start] = true;
		d[start] = 0;
		p[start] = -1;
		
		int nums = al[start].size();
		for(int i = 0; i < nums; i ++){
			int vert = (int) al[start].get(i);
			d[vert] = (int) aw[start].get(i);
			p[vert] = start;	
		}
		for(int i = 0; i < M; i ++){
			int min = Integer.MAX_VALUE;
			int newV = -1;
			for(int k = 0; k < M; k ++){
				if(!S[k] && d[k] < min){
					min = d[k];
					newV = k;
				}
			}
			S[newV] = true;
			nums = al[newV].size();
			for(int j = 0; j < nums; j++){
				int vert = (int) al[newV].get(j);
				int weight = (int) aw[newV].get(i);
				int newVal = d[newV] + weight;
				if(d[vert] > newVal){
					d[vert] = newVal;
					p[vert] = newV;
				}
			}
		}
	}
}
