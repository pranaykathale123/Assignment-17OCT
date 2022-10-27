package FifthProblem;
import java.util.*;

public class ArrangeLargeNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an array");
		int size = sc.nextInt();
		int [] arr = new int[size];
		System.out.println("enter elements in an array");
		for(int i=0; i<size; i++){
			arr[i]= sc.nextInt();
		}
		arrangeHighestValue(arr);
	}

	private static void arrangeHighestValue(int[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		for(int i:arr){
			System.out.print(i);
		}
	}
}
