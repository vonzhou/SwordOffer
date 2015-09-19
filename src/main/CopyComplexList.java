package main;

import java.util.ArrayList;
import java.util.List;

class ComplexListNode{
	int value;
	ComplexListNode next;
	ComplexListNode sibling;
	
	// for print
	public String toString(){
		String s = "(" + value + ",";
		if(sibling != null)
			s += sibling.value + ")";
		else s += "nil)";
		
		return s;
	}
}


public class CopyComplexList {
	
	
	public static ComplexListNode clone(ComplexListNode head){
		cloneNodes(head);
		connectSiblingNodes(head);
		
		return splitList(head);
	}

	public static ComplexListNode splitList(ComplexListNode head) {
		ComplexListNode p = head;
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		
		if(p != null){
			clonedHead = clonedNode = p.next;
			p.next = clonedNode.next;
			p = p.next;
		}
		
		while(p != null){
			clonedNode.next = p.next;
			clonedNode = clonedNode.next;
			
			p.next = clonedNode.next;
			p = p.next;
		}
		
		return clonedHead;
	}

	public static void connectSiblingNodes(ComplexListNode head) {
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode cloned = p.next; // the cloned Node 
			if(p.sibling != null){
				cloned.sibling = p.sibling.next; // cloned sibling is next to origin sibling
			}
			
			p = cloned.next;
		}
	}

	public static void cloneNodes(ComplexListNode head) {
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode tmp = new ComplexListNode();
			tmp.value = p.value;
			tmp.next = p.next;
			tmp.sibling = null;
			
			p.next = tmp;
			p = tmp.next; // iterate to next
		}
	}
	
	// 1->5 
		public static ComplexListNode create(){
			int N = 5;
			ComplexListNode[] nodes = new ComplexListNode[N];
			
			for(int i=0; i<5; i++){
				nodes[i] = new ComplexListNode();
				nodes[i].next = null;
				nodes[i].sibling = null;
			}
			
			for(int i=0; i<5; i++){
				nodes[i].value = i+1;
				if(i < N-1)
					nodes[i].next = nodes[i+1];
				else nodes[i].next = null;
			}
			
			nodes[0].sibling = nodes[2];
			nodes[1].sibling = nodes[4];
			nodes[3].sibling = nodes[1];
			
			
			return nodes[0];
		}
		
		public static String toString(ComplexListNode head){
			ComplexListNode p = head;
			String s = "[";
			while(p!=null){
				s += p + ",";
				p = p.next;
			}
			s+= "]";
			
			return s;
		}
	
	
	public static void main(String[]  args){
//		List<String> list = new ArrayList<String>();
//		list.add("hello");
//		func(list);
//		System.out.println(list);
		
		ComplexListNode head = create();
		System.out.println(toString(head));
		cloneNodes(head);
		System.out.println(toString(head));
		
		connectSiblingNodes(head);
		System.out.println(toString(head));
		
		ComplexListNode cloned = splitList(head);
		System.out.println(toString(cloned));
	}

	private static void func(List<String> list) {
		list.add("vonzhou");
	}

}
