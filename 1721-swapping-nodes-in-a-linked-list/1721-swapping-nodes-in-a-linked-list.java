class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode nodeKthFromBegin = null;
        ListNode nodeKthFromEnd = null;
        
        // Move fast pointer to the kth node from the beginning
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        nodeKthFromBegin = fast;
        
        // Move slow and fast pointers together until fast reaches the end of the list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        nodeKthFromEnd = slow;
        
        // Swap the values of the kth node from the beginning and the kth node from the end
        int temp = nodeKthFromBegin.val;
        nodeKthFromBegin.val = nodeKthFromEnd.val;
        nodeKthFromEnd.val = temp;
        
        return dummy.next;
    }
}