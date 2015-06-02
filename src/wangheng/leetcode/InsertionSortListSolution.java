package wangheng.leetcode;

public class InsertionSortListSolution {
    public ListNode insertionSortList2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode node = head;
        while (node != null) {
            ListNode curr = dummy;
            while (curr.next != null && curr.next.val <= node.val) curr = curr.next;
            ListNode tmp = node.next;
            node.next = curr.next;
            curr.next = node;
            node = tmp;
        }
            
        return dummy.next;   
    }
    
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
