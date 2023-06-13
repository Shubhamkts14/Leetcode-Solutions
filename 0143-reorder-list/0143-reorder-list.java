// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
    
//     public void reorderList(ListNode head) {
//       if (head == null || head.next == null)
//           return;
//       ListNode prev = null, slow = head, fast = head, l1 = head;
//         // find the  middle node using slow and fast pointer technique
//       while (fast != null && fast.next != null) {
//         prev = slow;
//         slow = slow.next;
//         fast = fast.next.next;
//       }
      
//       prev.next = null; // break the link between first and second halves
// // reverse the second half of the list starting from middle node
//       ListNode l2 = reverse(slow);
//       merge(l1, l2);
//     }
// // merge the first and reversed second half alternatively.    
//     ListNode reverse(ListNode head) {
//       ListNode prev = null, curr = head, next = null;
      
//       while (curr != null) {
//         next = curr.next;
//         curr.next = prev;
//         prev = curr;
//         curr = next;
//       }
      
//       return prev;
//     }
    
//     void merge(ListNode l1, ListNode l2) {
//       while (l1 != null) {
//         ListNode n1 = l1.next, n2 = l2.next;
//         l1.next = l2;
        
//         if (n1 == null)
//           break;
            
//         l2.next = n1;
//         l1 = n1;
//         l2 = n2;
//       }
//     }

//   }









class Solution{
    public void reorderList(ListNode head){
        if(head==null || head.next==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next !=null &&fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null;
        
        ListNode firstHalf = head;
        while(firstHalf != null && secondHalf != null){
            ListNode nextFirst = firstHalf.next;
            ListNode nextSecond = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = nextFirst;
            firstHalf = nextFirst;
            secondHalf = nextSecond;
        }
    }
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr= head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
        }
        return prev;
    }
}