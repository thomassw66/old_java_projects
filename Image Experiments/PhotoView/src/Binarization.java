import java.awt.Color;
import java.awt.image.BufferedImage;
import java.math.BigInteger;


public class Binarization {

	public static void binarize(BufferedImage a){
		int average = average(a);
		System.out.println(average);
		for(int i = 0; i < a.getWidth(); i++){
			for(int j = 0; j < a.getHeight(); j++){
				int bright = brightNess(a.getRGB(i, j));
				if(bright > average)
					bright = 255;
				else
					bright = 0;
				a.setRGB(i, j, (new Color(bright,bright,bright)).getRGB() );
			}
		}
	}
	static int average(BufferedImage a){
		BigInteger sum = BigInteger.ZERO;
		int n = 0;
		for(int i = 0; i < a.getWidth(); i++){
			for(int j = 0; j < a.getHeight(); j++){
				sum = sum.add(BigInteger.valueOf(brightNess(a.getRGB(i, j))));
				n++;
			}
		}
		return sum.divide(BigInteger.valueOf(n)).intValue();
	}
	static int brightNess(int rgb){
		int r = (rgb >> 16) & 255;
		int g = (rgb >> 8) & 255;
		int b = rgb & 255;
		return (int)((0.2126*r) + (0.7152*g) + (0.0722*b));
	}
}
