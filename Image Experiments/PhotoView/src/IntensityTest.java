
public class IntensityTest {

	public static int intensityFromRGB(int r,int g,int b){
		return (int)((0.2989 * r + 0.5870 * g + 0.1140 * b)+.5);
	}
}
