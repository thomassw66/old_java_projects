
import java.util.Scanner;


public class Main {

	public static void main(String [] args){
		Scanner input = new Scanner (System.in);
		int b = input.nextInt();
		input.nextLine();
		int i = 0;
		while(i < b){
			i++;
			System.out.println("Problem #"+i);
			System.out.println(solveLine(input.nextLine()));
			System.out.println();
		}
	}
	static String solveLine(String line){
		double I,U, P;
		I = U = P = Double.MAX_VALUE;
		
		int eq1 = line.indexOf('=');
		
		int start = eq1 + 1;
		int end;
		
		int i = start;
		while(true){
			char c = line.charAt(i);
			if(!(Character.isDigit(c) || c == '.')){
				end = i;
				break;
			}
			i++;
		}
		double temp = Double.parseDouble(line.substring(start,end));
		//System.out.println(temp);
		
		char prefix = line.charAt(end);
		
		switch (prefix){
			case 'm':
				temp = temp/1000;
				break;
			case 'k':
				temp = temp * 1000;
				break;
			case 'M':
				temp = temp * 1000000;
				break;
		}
		
		//System.out.println(BigDecimal.valueOf(temp));
		
		char var = line.charAt(eq1-1);
		
		switch(var){
		
			case 'U':
				U = temp;
				break;
			case 'P':
				P = temp;
				break;
			case 'I':
				I = temp;
				break;
				
			default:
				break;
		}
		
		
		int eq2 = line.indexOf('=', eq1 + 1);
		//System.out.println(eq1  + " " + eq2);
		int start2 = eq2 + 1;
		int end2;
		
		int i2 = start2;
		while(true){
			char c = line.charAt(i2);
			if(!(Character.isDigit(c) || c == '.')){
				end2 = i2;
				break;
			}
			i2++;
		}
		double temp2 = Double.parseDouble(line.substring(start2,end2));
		//System.out.println(temp2);
		
		char prefix2 = line.charAt(end2);
		
		switch (prefix2){
			case 'm':
				temp2 = temp2/1000;
				break;
			case 'k':
				temp2 = temp2 * 1000;
				break;
			case 'M':
				temp2 = temp2 * 1000000;
				break;
		}
		
		//System.out.println(BigDecimal.valueOf(temp2));
		
		char var2 = line.charAt(eq2-1);
		
		switch(var2){
			case 'U':
				U = temp2;
				break;
			case 'P':
				P = temp2;
				break;
			case 'I':
				I = temp2;
				break;
		}
		
		String r = "";
		if(I == Double.MAX_VALUE){
			I = P / U;
			r = String.format("I=%.2fA", I);
		}else if(U == Double.MAX_VALUE){
			U = P / I;
			r = String.format("U=%.2fV", U);
		}else if(P == Double.MAX_VALUE){
			P = U*I;
			r = String.format("P=%.2fW", P);
		}
		
		return r;
	}
}
