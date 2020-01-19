package hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import general.ListNode;

public class MergeKSortedLists_23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode[] lists = new ListNode[3];
		ListNode head1 = new ListNode(1);
		ListNode l1n1 = head1;
		lists[0] = head1;
		l1n1.next = new ListNode(4);
		l1n1 = l1n1.next;
		l1n1.next = new ListNode(5);
		l1n1 = l1n1.next;
		l1n1.next=null;
		
		ListNode head2 = new ListNode(1);
		ListNode l2n1 = head2;
		lists[1] = head2;
		l2n1.next = new ListNode(3);
		l2n1 = l2n1.next;
		l2n1.next = new ListNode(4);
		l2n1 = l2n1.next;
		l2n1.next = null;
		
		ListNode head3 = new ListNode(2);
		ListNode l3n1 = head3;
		lists[2] = head3;
		l3n1.next = new ListNode(6);
		l3n1 = l3n1.next;
		l3n1.next = null;
		
		ListNode ansHead = mergeKLists(lists);
		while(ansHead!=null) {
			System.out.println(ansHead.val + "-->");
			ansHead= ansHead.next;
		}
	}

	 public static ListNode mergeKLists(ListNode[] lists) {
	        
	        if(lists.length==0 || lists ==null)
	            return null;
	        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
	           @Override
	            public int compare(ListNode l1, ListNode l2){
	                return Integer.compare(l1.val, l2.val);
	            }
	        });
	        //fill k elements into pq
	        for(int i=0; i<lists.length; i++){
	            if(lists[i]!=null)
	                pq.add(lists[i]);
	        }
	        ListNode tempHead = new ListNode(0);
	        ListNode prev = tempHead;
	        ListNode cur;
	        while(!pq.isEmpty()){
	            cur= pq.poll();
	            if(cur.next!=null){
	                pq.add(cur.next);
	            }
	            prev.next = cur;
	            prev= cur;
	            
	        }
	        return tempHead.next;
	    }
	/*
	 * public static ListNode mergeKListsOLD (ListNode[] lists) { if(lists==null)
	 * return null; PriorityQueue<ListNode> pq = new
	 * PriorityQueue<ListNode>(lists.length, new ValComparator()); for(int
	 * i=0;i<lists.length;i++) { pq.add(lists[i]); } ListNode head = null;
	 * if(!pq.isEmpty()) { head = pq.poll(); if(head.next!=null) pq.add(head.next);
	 * } ListNode currentNode = head;
	 * 
	 * while(!pq.isEmpty()) { ListNode temp = pq.poll(); if(temp.next!=null)
	 * pq.add(temp.next); currentNode.next= temp; currentNode = currentNode.next; }
	 * return head; }
	 * 
	 * }
	 * 
	 * class ValComparator implements Comparator<ListNode>{
	 * 
	 * @Override public int compare(ListNode o1, ListNode o2) { if(o1.val<o2.val)
	 * return -1; if(o1.val>o2.val) return 1; return 0; }
	 */	
}