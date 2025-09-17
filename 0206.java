/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> S = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            S.add(temp);
            temp = temp.next;
        }
        if (!S.isEmpty()) {
            ListNode header = S.pop();
            ListNode temper = header;
            while (!S.isEmpty()) {
                temper.next = S.pop();
                temper = temper.next;
            }
            temper.next = null;
            return header;
        } else
            return null;
    }
}