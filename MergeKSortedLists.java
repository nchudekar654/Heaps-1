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