package main;

public class FindListCircle {
	
	// p1 step one and p2 step two 
	public static boolean hasCircle(ListNode list){
		if(list == null )
			return false;
		
		if(list.next == list)
			return true;
		
		
		ListNode p = list;
		ListNode slow = p;
		ListNode fast = p;
		
		// fast go first
		if(fast.next != null)
			fast = fast.next;
		else return false;
		
		if(fast.next != null)
			fast = fast.next;
		else return false;
		
		// ok , we step the same time...
		while(fast.next != null){
			if(slow == fast)
				return true;
			
			fast = fast.next;
			if(fast.next != null)
				fast = fast.next;
			else return false;
			
			slow = slow.next;
		}
		
		
		return false;
	}
}
