public class RotateList {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || k == 0 || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int size = getLength(head);
        k =  k % size;
        System.out.println(k+" "+size);
        if(k == 0){
            return head;
        }
        while(k > 0){
            fast = fast.next;
            k--;
        }       

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        } 

        ListNode rotatedHead = slow.next;
        slow.next = null;
        fast.next = head;

        return rotatedHead;
    }

    public int getLength(ListNode head){
        int cnt = 0;
        ListNode curr = head;
        while(curr != null){
            cnt++;
            curr = curr.next;
        }

        return cnt;
    }
}
}

//MISTAKE -> FORGOT TO DO SLOW.NEXT = NULL.
