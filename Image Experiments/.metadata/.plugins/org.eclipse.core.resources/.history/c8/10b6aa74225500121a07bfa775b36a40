
public class Test {

	public static void main(String [] args){
		int rgb = 0xFFFFFF;
		
		//separate into different bytes
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = rgb & 0xFF;
		//put back into an int
		int new_rgb = (((r<<16) + (g<<8) + b));
		
		System.out.println(r + " " + g + " " + b);
		System.out.printf("%d = %d %b %n", rgb, new_rgb, new_rgb == rgb);
		System.out.print(Integer.toHexString(rgb));
		System.out.println(" " + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b));
		
		System.out.println((int)Math.ceil(.5));
	}
}
