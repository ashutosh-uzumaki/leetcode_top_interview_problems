public class AddTwoNumbers {
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        int carry = 0;
        while(curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = node;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        while(curr1 != null){
            int sum = curr1.val + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = node;
            curr1 = curr1.next;
        }

        while(curr2 != null){
            int sum = carry + curr2.val;
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            tail.next = node;
            tail = node;
            curr2 = curr2.next;
        }

        if(carry > 0){
            ListNode node = new ListNode(carry);
            tail.next = node;
            tail = node;
        }

        return dummy.next;
    }
} 
}
