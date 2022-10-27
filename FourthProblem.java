package fourthProblem;
import java.util.*;
import java.lang.*;

public class FourthProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter x:");
	    int x = sc.nextInt();

	    System.out.println("Enter n:");
	    int n = sc.nextInt();

	    System.out.println("\n\nPow(" + x + "," + n + "):" + pow(x, n));
		       
	}

	private static long pow(int x, int power) {
		// TODO Auto-generated method stub
		
			if (power == 0){
				 return 1;
			 }
			if (power == 1){
		    	return x;
		    }
			long res = pow(x, power / 2);
			
		    if(power % 2 == 0){
		    	return res * res;
		    }
		    else
		      return x * res * res; 
		  }
	}

