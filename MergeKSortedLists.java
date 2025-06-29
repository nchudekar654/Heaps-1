//Time Complexity: O(log k) - heap insert, O(log k) - heap remove/poll, n- number of nodes 
// O(n*log k)
//Auxillary space - O(k)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        ListNode result = new ListNode(-1);
        ListNode curr = result;
        for(ListNode head: lists){
            if(head!= null){
                pq.add(head);

            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            curr.next = min;
            if(min.next != null){
                pq.add(min.next);
            }
            curr = curr.next;

        }
        return result.next;
    }
}

//Solution: Merging list one by one
//Time Comlpexity - O(k*n)
//Space Complexity - O(1)

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode merged = new ListNode(Integer.MIN_VALUE);
        for(ListNode head: lists){
            if(head != null){
                merged = merge(merged, head);
            }
        }
        return merged.next;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null && p2!=null){
            if(p1.val < p2.val){
                curr.next = p1;
                p1 = p1.next;
            }
            else{
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if(p1 == null){
            curr.next = p2;
        }
        if(p2 == null){
            curr.next = p1;
        }
       return dummy.next; 
    }
}