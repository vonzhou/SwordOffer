package main;

public class KthNodeFromEnd {
	
	//1. traverse twice, pupu....
	public static ListNode findKthFromTailBrute(ListNode list, int k){
		if(list == null || k == 0)
			return null;
		
		int n = 0;
		ListNode p = list;
		while(p != null){
			n ++;
			p = p.next;
		}
		
		int step = n - k;
		if(step < 0)
			return null;
		
		p = list;
		while(step > 0){
			p = p.next;
			step -- ;
		}
		
		return p;
	}
	
	// 2. use two pointers 
	public static ListNode findKthFromTail(ListNode list, int k){
		if(list == null || k == 0)
			return null;
		ListNode slow = null;
		ListNode fast = list;
		
		// the fast pointer will before k steps
		for(int i=0; i < k-1; i++){
			if(fast.next != null)
				fast = fast.next;
			else return null;
		}
		// then move the slow pointer
		slow = list;
		while(fast.next != null){
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,};
		ListNode list = ListUtil.createListFromArray(arr);
		ListNode kth = findKthFromTail(list, 2);
		System.out.println(kth.val);
	}
	
}
