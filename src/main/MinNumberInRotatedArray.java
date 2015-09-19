package main;

public class MinNumberInRotatedArray {
	
	/*
	 * Not work if left, mid , right value is same , go what part ?
	 * {1,0,1,1,1} {1,1,1,0,1}
	 */
	public static int minNotPerfect(int[] arr){
		if(arr == null || arr.length <=0 )
			return -9999;
		
		if(arr.length == 1)
			return arr[0];
		
		int p1 = 0;
		int p2 = arr.length - 1;
		int mid = p1; 
		while(arr[p1] >= arr[p2]){ // 
			if(p2 - p1 == 1){
				mid = p2;
				break;
			}
			mid = (p1+p2)/2;
			if(arr[mid] <= arr[p1])
				p2 = mid;
			else if(arr[mid] >= arr[p2])
				p1 = mid;
		}
		return arr[mid];
	}
	
	public static int min(int[] arr){
		if(arr == null || arr.length <=0 )
			return -9999;
		
		if(arr.length == 1)
			return arr[0];
		
		int p1 = 0;
		int p2 = arr.length - 1;
		int mid = p1;  
		while(arr[p1] >= arr[p2]){
			if(p2 - p1 == 1){
				mid = p2;
				break;
			}
			mid = (p1+p2)/2;
			
			// Specific case!!!
			if(arr[p1] == arr[mid] && arr[p2]==arr[mid])
				return bruteMin(arr, p1, p2);
			
			if(arr[mid] <= arr[p1])
				p2 = mid;
			else if(arr[mid] >= arr[p2])
				p1 = mid;
		}
		return arr[mid];
	}
	
	// 
	private static int bruteMin(int[] arr, int p1, int p2) {
		int min = arr[p1];
		for(int i=p1; i<=p2; i++){
			if(arr[i] <= min)
				min = arr[i];
		}
		return min;
	}


	
	public static void main(String[] args) {
		int[] a = {3,4,5,1,2};
		int[] b = {1};
		System.out.println(min(a));
		System.out.println("-------------------------");
		
		int[] c ={1,0,1,1,1};
		System.out.println(min(c));
		System.out.println(minNotPerfect(c));
		System.out.println("-------------------------");
		
		int[] d = {1,1,1,0,1};
		System.out.println(min(d));
		System.out.println(minNotPerfect(d));
	}

}
