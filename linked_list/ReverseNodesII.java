public class ReverseNodesII {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 1;
        while(i < left){
            prev = prev.next;
            i++;
        }

        ListNode curr = prev.next;
        for(i=1; i<=right-left; i++){
            ListNode temp = prev.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }
        return dummy.next;
    }
}
}

//WAS NOT ABLE TO SOLVE MYSELF HAD TO LOOK FOR THE SOLUTION.

