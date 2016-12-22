
public class BinaryString {

	public static void main(String [] args){
		String s = Integer.toString(8, 8);
		System.out.println(s);
	}
	public static long fromBinaryString(String binstr){
		long i = 0;
		char c;
		for(int j = 0; j < binstr.length(); j++){
			c = binstr.charAt(j);
			i = i << 1;
			if(c == '1')
				i++;
			
		}
		return i;
	}
	public static String toBinaryString(long a){
		String ret = "";
		while(a > 0){
			if((a & 1) != 0)
				ret = '1' + ret;
			else 
				ret = '0' + ret;
			a = a >> 1;
		}
		return ret;
	}
}
