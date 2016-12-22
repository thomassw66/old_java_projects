import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class FloodPainter {
	
	static int tolerance = 55;
	static final int [][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static int rgb;
	static int [] rgbs;
	static int origintensity;
	
	public static void floodPaint(int x, int y, BufferedImage image,Graphics graph){
		boolean [][] been = new boolean[image.getWidth()][image.getHeight()];

		if(x < been.length && x >= 0 && y < been[0].length && y >= 0){
			System.out.println(x +" " + y+" "+been.length+" "+been[0].length);
			rgb = image.getRGB(x, y);

			int r = (rgb >> 16) & 255;
			int g = (rgb >> 8) & 255;
			int b = rgb & 255;
			rgbs = new int[3];
			rgbs[0] = r;
			rgbs[1] = g;
			rgbs[2] = b;
			
			floodPaint(x,y,image,graph,been);
		}
	}
	public static void floodPaint(int x, int y, BufferedImage image,Graphics graph, boolean [][] been){
		been[x][y] = true;
		graph.fillRect(x, y, 1, 1);
		for(int [] d : delta){
			int xi = x + d[0];
			int yi = y + d[1];
			if(xi < been.length && xi >= 0 && yi < been[0].length && yi >= 0){
				if(!been[xi][yi]){
					int rgbi = image.getRGB(x, y);

					int ri = (rgbi >> 16) & 255;
					int gi = (rgbi >> 8) & 255;
					int bi = rgbi & 255;
					
					int [] rgbis = {ri,gi,bi};
					
					boolean canfill = true;
					for(int i = 0; i < 3; i++){
						canfill = canfill && (rgbis[i] < (rgbs[i] + tolerance) && rgbis[i] > (rgbs[i] - tolerance));
					}

					//if any of the pixel are much different canfill will be false
					if(canfill)
						floodPaint(xi,yi,image,graph,been);
				}
			}
		}
	}
	public static void floodPaint2(int x, int y, BufferedImage image ,Graphics graph){
		graph.setColor(Color.red);
		ArrayList<int[]> steeve = new ArrayList<int[]>();
		boolean [][] been = new boolean[image.getWidth()][image.getHeight()];

		if(x < been.length && x >= 0 && y < been[0].length && y >= 0){
			System.out.println(x +" " + y+" "+been.length+" "+been[0].length);
			rgb = image.getRGB(x, y);

			int r = (rgb >> 16) & 255;
			int g = (rgb >> 8) & 255;
			int b = rgb & 255;
			origintensity = IntensityTest.intensityFromRGB(r, g, b);

			int [] a = {x,y};
			been[x][y] = true;
			steeve.add(a);
			
			while(steeve.size() > 0){
				int [] point = steeve.remove(0);
				
				x = point[0];
				y = point[1];

				been[x][y] = true;
				
				graph.fillRect(x, y, 1, 1);
				for(int [] d : delta){
					int xi = x + d[0];
					int yi = y + d[1];
					if(xi < been.length && xi >= 0 && yi < been[0].length && yi >= 0){
						if(!been[xi][yi]){

							been[xi][yi] = true;
							int rgbi = image.getRGB(x, y);

							int ri = (rgbi >> 16) & 255;
							int gi = (rgbi >> 8) & 255;
							int bi = rgbi & 255;
							
							int intense = IntensityTest.intensityFromRGB(ri, gi, bi);
							
							
							if(Math.abs(origintensity - intense) <= tolerance){
								int [] c = {xi,yi};
								steeve.add(c);
							}
						}
					}
				}
			}
			
		}else{
			throw new IllegalArgumentException("X or Y were out of bounds");
		}
	}
}
