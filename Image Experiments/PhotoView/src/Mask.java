import java.awt.image.BufferedImage;


public abstract class Mask {
	BufferedImage image;
	public Mask(BufferedImage b){
		image = b;
	}
	public boolean inBounds(int x, int y){
		return x >= 0 && x < image.getWidth() && y >= 0 && y < image.getHeight();
	}
	public abstract int filter(int x, int y);
	public BufferedImage result(){
		BufferedImage a = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		for(int i = 0; i < a.getWidth();i++){
			for(int j = 0; j < a.getHeight(); j++){
				a.setRGB(i, j, RGB.rgb(filter(i,j)));
			}
		}
		return a;
	}
}
