public class Solution { 
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        // compare the heads of l1 and l2
        ListNode head;

        if(l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        head.next = mergeTwoLists(l1, l2);

        return head;
    }

        public ListNode itr_mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        // iterate until we reach the end of one list
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;

        return head.next;
    }
    public static void main(String[] args) {

    }
}