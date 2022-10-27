package thirdproblem;
import java.util.*;


public class Twosum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the size of an array");
		int size = sc.nextInt();
		int []arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println("enter the target value for which your finding sum pairs");
		int target = sc.nextInt();
		for(int i=0; i<size; i++){
			int ans =searchElement(arr,target-arr[i]);
			if(ans!=-1){
				System.out.println(i+","+ans);
			}
			
		}
		System.out.println();
		System.exit(0);
		
	}

	private static int searchElement(int[] arr, int target) {
		// TODO Auto-generated method stub
		int start = 0;
		int end = arr.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(arr[mid]<target){
				start = mid+1;
			}else if(arr[mid]>target){
				end = mid-1;
			}else{
				return mid;
			}
		}
		return -1;
	}

}
