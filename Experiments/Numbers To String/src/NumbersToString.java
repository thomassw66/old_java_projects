
public class NumbersToString {
	static String [] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	static String [] tens = {"", "Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	static String [] stuff = {"Hundred","Thousand","Million","Billion"};
	
	public static String toString(int i){
		String ret = "";
		ret += ones[i % 10];
		i /= 10;
		ret = tens[i % 10] + ret;
		i /= 10;
		return ret;
	}
	public static void main(String [] args){
		System.out.println(toString(11));
	}
}