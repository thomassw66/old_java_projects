
public class TNum {
	
	byte [] bits;
	int size;
	int signum;
	
	private TNum(){}
	
	public static TNum valueof(long l){
		TNum t = new TNum();
		int size;
		
		if(l == 0){
			t.signum = 0;
			size = 1;
		}
		else {
			if(l < 0){
				l = -l;
				t.signum = -1;
			}else{
				t.signum = 1;
			}

			size = Long.SIZE - Long.numberOfLeadingZeros(l);
		}
		
		
		
		t.bits = new byte[size];
		t.size = size;
		
		int bit = 0;
		long temp = l;
		while(bit < size){
			t.bits[bit++] = (byte) (temp & 1);
			temp >>= 1;
		}
		return t;
	}
	public String toString(){
		String ret = "";
		int s = size - 1;
		while(s >= 0){
			ret += bits[s--];
		}
		return ret;
	}
	byte [] fromAddingTwo(TNum a, TNum b){
		if(a.size < b.size){
			TNum temp = a;
			a = b;
			b = temp;
		}
			
		
		int needed = Math.max(a.size, b.size);
		int min = Math.min(a.size, b.size);
		
		byte [] longer = new byte[needed + 1];
		byte [] shorter = new byte[needed];
		
		int index = 0;
		int carry = 0;
		
		while (index < min){
			int sum =  (a.bits[index] + b.bits[index] +carry);
			
			int value =  (sum & 1);
			carry = sum >> 1;
		
			longer[index] = shorter[index] = (byte) value;
			index ++;
		}
		while(index < needed){
			int sum = (a.bits[index] + carry);
			
			longer[index] = shorter[index] = (byte) (sum & 1) ;
			carry = sum >> 1;
			
			index ++;
		}
		
		if(carry != 0){
			longer[needed] = (byte) carry;
			return longer;
		}
		return shorter;
	}
	
	public TNum __add__(TNum a){
		TNum t = new TNum();
		t.bits = fromAddingTwo(this, a);
		t.size = t.bits.length;
		t.signum = 1;
		return t;
	}
}
