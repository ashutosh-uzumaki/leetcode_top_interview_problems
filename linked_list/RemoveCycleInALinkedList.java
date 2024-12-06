public class RemoveCycleInALinkedList {


  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class Solution {
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return A;
        }

        slow = A;

        while(slow  != fast){
            slow = slow.next;
            fast = fast.next;
        }

        ListNode prev = fast;

        while(prev.next != slow){
            prev = prev.next;
        }

        prev.next = null;

        return A;
    }
}

}
