package wangheng.leetcode;

public class InsertionSortListSolution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = null, curr = null, insertion = null;
        ListNode headOfUnsorted = head.next;
        
        head.next = null;
        
        while (headOfUnsorted != null) {
            insertion = headOfUnsorted;
            headOfUnsorted = headOfUnsorted.next;
            
            pre = dummy;
            curr = dummy.next;
            
            while (curr != null && curr.val < insertion.val) {
                curr = curr.next;
                pre = pre.next;
            }
            
            pre.next = insertion;
            insertion.next = curr;
        }
        
        return dummy.next;
    }

}
