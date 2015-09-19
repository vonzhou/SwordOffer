package main;

public class FindListMiddleNode {
	
	// p1 step one and p2 step two 
	public static ListNode getMiddleNode(ListNode list){
		if(list == null )
			return null;
		
		
		ListNode p = list;
		ListNode slow = p;
		ListNode fast = p;
		
		// ok , we step the same time...
		while(fast.next != null){
			fast = fast.next;
			if(fast.next != null)
				fast = fast.next;
			else return slow;
			
			slow = slow.next;
		}
		
		
		return slow;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		ListNode list = ListUtil.createListFromArray2(arr);
		ListNode kth = getMiddleNode(list);
		System.out.println(kth.val);
	}
}
