public class ReverseNodeInKGroups {
  
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public int getNodesCount(ListNode head){
        int size = 0;
        while(head != null){
            size += 1;
            head = head.next;
        }
        return size;
    }
    public void reverse(ListNode head){
        ListNode curr = head;
        ListNode temp = curr;
        ListNode prev = null;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = getNodesCount(head);
        ListNode resultantHead = new ListNode(-1);
        ListNode resultantTail = resultantHead;

        while(head != null){
            if(size < k){
                resultantTail.next = head;
                break;
            }

            ListNode groupHead = new ListNode(-1);
            ListNode groupTail = groupHead;

            for(int i=0; i<k; i++){
                ListNode next = head.next;
                groupTail.next = head;
                groupTail = head;
                head = next;
            }
            groupTail.next = null;
            groupHead = groupHead.next;
            reverse(groupHead);
            resultantTail.next = groupTail;
            resultantTail = groupHead;
            size -= k;
        }
        return resultantHead.next;
    }
}
}

//FOUND ISSUE IN LINKING GROUP.
