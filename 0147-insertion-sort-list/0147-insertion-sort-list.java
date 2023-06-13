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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pointerToHead = new ListNode();
        pointerToHead.next = head;
        ListNode nextToInsert = head.next;
        head.next = null;
        while (nextToInsert != null) {
            ListNode willBeNext = nextToInsert.next;
            int x = nextToInsert.val;
            ListNode insertAfter = pointerToHead;
            while (insertAfter.next != null && insertAfter.next.val < x) {
                insertAfter = insertAfter.next;
            }
            ListNode insertBefore = insertAfter.next;
            insertAfter.next = nextToInsert;
            nextToInsert.next = insertBefore;
            nextToInsert = willBeNext;
        }
        return pointerToHead.next;
    }
}