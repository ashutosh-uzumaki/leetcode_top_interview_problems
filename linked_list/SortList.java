public class SortList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        ListNode rightList = mid.next;
        mid.next = null;
        ListNode leftList = head;
        leftList = sortList(leftList);
        rightList = sortList(rightList);

        return mergeList(leftList, rightList);
    }

    public ListNode mergeList(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        ListNode curr1 = head1;
        ListNode curr2 = head2;

        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                tail.next = curr1;
                tail = tail.next;
                curr1 = curr1.next;
            }else{
                tail.next = curr2;
                tail = tail.next;
                curr2 = curr2.next;
            }
        }

        if(curr1 != null){
            tail.next = curr1;
        }else{
            tail.next = curr2;
        }

        return dummy.next;
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    
}
}
