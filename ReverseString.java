import java.util.*;
public class ReverseString {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string to be check");
		String str = sc.nextLine();
		System.out.print(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {
		// TODO Auto-generated method stub
		int start=0;
		int end =str.length()-1;
		while(start<end){
			if(str.charAt(start)==str.charAt(end)){
				start++;
				end--;
				
				
			}else{
				return false;
			}
		}
		return true;
		
	}
	
	

}
