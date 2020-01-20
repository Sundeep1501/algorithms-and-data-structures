/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        while(head.next != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }*/
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        return reverse(null,head);
    }
    
    ListNode reverse(ListNode prev, ListNode head){
        if(head == null){
            return prev;
        }
        ListNode temp = head.next;
        head.next = prev;
        return reverse (head,temp);
    }
    
    
}
