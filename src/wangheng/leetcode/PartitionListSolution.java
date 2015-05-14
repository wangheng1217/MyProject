package wangheng.leetcode;

public class PartitionListSolution {
    public ListNode partition2(ListNode head, int x) {
        ListNode dummyL = new ListNode(0);
        ListNode dummyG = new ListNode(0);
        ListNode preL = dummyL, preG = dummyG;

        while (head != null) {
            if (head.val < x) {
                preL.next = head;
                preL = preL.next;
            } else {
                preG.next = head;
                preG = preG.next;
            }
            head = head.next;
        }
        
        if (preL == null) return dummyG.next;
        
        preL.next = dummyG.next;
        if (preG != null) preG.next = null;
        return dummyL.next;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode head1 = null, curr1 = null, head2 = null, curr2 = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (head1 == null) {
                    head1 = curr;
                    curr1 = curr;
                } else {
                    curr1.next = curr;
                    curr1 = curr1.next;
                }
            } else {
                if (head2 == null) {
                    head2 = curr;
                    curr2 = curr;
                } else {
                    curr2.next = curr;
                    curr2 = curr2.next;
                }
            }
            curr = curr.next;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        curr1.next = head2;
        curr2.next = null;
        return head1;
    }

}
