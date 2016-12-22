
public class CommonCharacters {

	public static void main (String [] args){
		
	}
	// order n^2 strait forward approach
	public static String commonChars(String a, String b){
		String ret = "";
		for(int i = 0; i < a.length(); i++){
			char c = a.charAt(i);
			for(int j = 0; j < b.length() ; j++){
				char d = b.charAt(j);
				if(c==d){
					ret+=c;
					a = a.substring(0,i) + a.substring(i+1);
					b = b.substring(0,j) + b.substring(j+1);
					System.out.println("removing char at " + i+" & "+j);
					System.out.println(a + " " + b);
					
					i--;
					break;
				}
			}
		}
		return ret;
	}
	
}
