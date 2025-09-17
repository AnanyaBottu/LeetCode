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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> S = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            S.add(temp.val);
            temp = temp.next;
        }
        ListNode temp1 = head;
        while (!S.isEmpty()) {
            if (S.pop() != temp1.val)
                return false;
            temp1 = temp1.next;
        }
        return true;

    }
}