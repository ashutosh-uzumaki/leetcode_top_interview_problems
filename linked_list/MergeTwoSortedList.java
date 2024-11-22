public class MergeTwoSortedList {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        while(curr1 != null && curr2 != null){
            if(curr1.val <= curr2.val){
                ListNode node = new ListNode(curr1.val);
                tail.next = node;
                tail = node;
                curr1 = curr1.next;
            }else{
                ListNode node = new ListNode(curr2.val);
                tail.next = node;
                tail = node;
                curr2 = curr2.next;
            }
        }

        if(curr1 != null){
            tail.next = curr1;
        }

        if(curr2 != null){
            tail.next = curr2;
        }

        return dummy.next;
    }
}
}

//MISTAKE - WAS CHECKING IF(CURR1.NEXT != NULL) WHEREAS I SHOULD HAVE CHECKED IF (CURR != NULL)


