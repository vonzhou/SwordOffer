package main;

import java.util.Arrays;

public class InversePairs {
	
	/*
	 * 1. Brute  , O(n^2)
	 */
	
	//----------------------------------------------------------------------------
	// O(n log n)
	public int inverseCount(int arr[]){
		if(arr.length < 2)
			return 0;
		int m = (arr.length+1)/2; // because range is [...)
		int[] left = Arrays.copyOfRange(arr, 0, m);
		int[] right = Arrays.copyOfRange(arr, m, arr.length);
		
		return inverseCount(left) + inverseCount(right) + merge(arr, left, right);
	}
	
	// merge and count ....
	public int merge(int arr[], int[] left, int[] right){
		int i=0, j=0, count = 0;
		// cover all the elements in the two parts
		while(i < left.length || j < right.length){
			if(i == left.length){
				arr[i+j] = right[j];
				j++;
			}else if(j == right.length){
				arr[i+j] = left[i];
				i++;
			}else if(left[i] <= right[j]){
				arr[i+j] = left[i];
				i ++;
			}else{
				arr[i+j] = right[j];
				count += left.length - i;
				j++;
			}
		}
		return count;
	}
	//------------------------------------------------------------------------------
	/*
	 * 2. ���ù鲢�����˼����зֽ�
	 */
	public int inversePairs(int[] data, int len){
		if(data == null || len <= 0)
			return 0;
		int[] aux = Arrays.copyOf(data, len);
		int count = mergeAndCount(data, aux, 0, len-1);
		
		aux = null;
		return count;
	}

	public int mergeAndCount(int[] data, int[] aux, int from, int to) {
		if(from == to){
			aux[from] = data[from];
			return 0;
		}
		
		int len = (to-from)/2;
		int left = mergeAndCount(aux, data, from, from + len);
		int right = mergeAndCount(aux, data, from+len+1, to);
		
		int i = from + len;
		int j = to;
		int indexCopy = to;
		int count = 0;
		while(i>=from && j >= from+len+1){
			if(data[i] > data[j]){
				aux[indexCopy--] = data[i--];
				count += j-from-len;
			}else{
				aux[indexCopy--] = data[j--];
			}
			
		}
		for(;i>=from;i--)
			aux[indexCopy--] = data[i];
		for(;j>=from+len+1;j--)
			aux[indexCopy--] = data[j];
		
		return left+right+count;
	}
	
	public static void main(String[] args) {
		InversePairs ip = new InversePairs();
		int[] a = {7,5,6,4,};
		System.out.println(ip.inversePairs(a, a.length));
		System.out.println(ip.inverseCount(a));
	}
	
	

}















