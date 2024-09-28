package linked_list;

import java.util.*;

public class HasCycle {
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      } }
class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }

        return false;

        
    }
}
}

//MISTAKE - DID slow != fast at the start instead of fast.next != null.
//WHILE RETURNING I WAS CHECKING FOR FAST != SLOW;
