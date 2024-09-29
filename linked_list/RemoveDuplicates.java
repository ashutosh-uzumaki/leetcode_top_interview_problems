public class RemoveDuplicates{
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr = head;
        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                int val = curr.val;
                while(curr != null && curr.val == val){
                    curr = curr.next;
                }
            }else{
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            }
        }
        tail.next = null;
        return dummy.next;
    }
}
}

//mistake -> FORGOT TO DO TAIL.NEXT = NULL
