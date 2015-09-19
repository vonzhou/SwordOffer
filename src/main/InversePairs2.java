package main;

import java.util.Arrays;

//http://www.geeksforgeeks.org/counting-inversions/

public class InversePairs2 {
	// O(n log n)
	public int inverseCount(int arr[]) {
		if (arr.length < 2)
			return 0;

		int[] tmp = new int[arr.length];// act as a buffer

		return mergeSort(arr, tmp, 0, arr.length - 1);
	}

	public int mergeSort(int[] arr, int[] tmp, int left, int right) {
		int mid, count = 0;
		if (right > left) {
			mid = (left + right) / 2;
			count = mergeSort(arr, tmp, left, mid);
			count += mergeSort(arr, tmp, mid + 1, right);

			// merge the two parts
			count += merge(arr, tmp, left, mid + 1, right);
		}

		return count;
	}

	// merge and count ....
	public int merge(int arr[], int tmp[], int left, int mid, int right) {
		int i = 0, j = 0, k = 0, count = 0;

		i = left; 
		j = mid; 
		k = left; 
		
		while( i<=(mid-1) && j<=right){
			if(arr[i] <= arr[j]){
				tmp[k++]  = arr[i++];
			}else{
				tmp[k++] = arr[j++];
				count = count + (mid-i);
			}
		}
		
		while(i <= mid-1)
			tmp[k++] = arr[i++];
		while(j <= right)
			tmp[k++] = arr[j++];
		
		// copy back and get ordered array!!!
		for(i=left; i<=right; i++)
			arr[i] = tmp[i];
		
		return count;
	}

	public static void main(String[] args) {
		InversePairs2 ip = new InversePairs2();
		int[] a = { 7, 5, 6, 4, };
		System.out.println(ip.inverseCount(a));
	}

}
