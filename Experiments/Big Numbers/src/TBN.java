import java.util.ArrayList;


public class TBN implements Comparable<TBN>{
	
	Integer [] nums;
	int size;
	
	public static TBN ZERO = TBN.valueof(0);
	public static TBN ONE = TBN.valueof(1);
	public static TBN TWO = TBN.valueof(2);
	public static TBN TEN = TBN.valueof(10);
	
	private TBN(){}
	private TBN(Integer [] num){
		nums = num;
		size = nums.length;
	}
	
	public static TBN valueof(long s){
		if(s == 0){
			Integer [] a = {0};
			return new TBN(a);
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		long temp = s;
		
		while(temp > 0){
			a.add((int) (temp % 10));
			temp = temp / 10;
		}
		
		TBN t = new TBN(a.toArray(new Integer[a.size()]));
		return t;
	}
	public static TBN add(TBN a, TBN b){
		//so we know a will always be bigger than b
		if(a.size < b.size){
			TBN temp = a;
			a = b;
			b = temp;
		}
		
		ArrayList<Integer> sum = new ArrayList<Integer>();
		
		int carry = 0;
		int index = 0;
		
		while(index < b.size){
			int tot = a.nums[index] + b.nums[index] + carry;
			
			sum.add((int) (tot % 10));
			
			carry = tot / 10;
			index++;
		}
		while(index < a.size){
			int tot = a.nums[index] + carry;
			
			sum.add((int) (tot % 10));
			
			carry = tot / 10;
			index++;
		}
		if(carry > 0)
			sum.add(carry);
		
		return new TBN(sum.toArray(new Integer[sum.size()]));
	}
	
	public int compareTo(TBN a) {
		int dif = size - a.size;
		if(dif != 0)
			return dif;
		else{
			int index = size - 1;
		}
		return 0;
	}
	
	public String toString(){
		String ret = "";
		int index = 0;
		while(index < size){
			ret = nums[index] + ret;
			index++;
		}
		return ret;
	}
}
