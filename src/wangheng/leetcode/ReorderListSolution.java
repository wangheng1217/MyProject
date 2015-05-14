package wangheng.leetcode;

public class ReorderListSolution {
    public void reorderList2(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            if (fast.next == null) fast = null;
            else fast = fast.next.next;
        }
        if (pre != null) pre.next = null;
        
        // reversr list from curr;
        ListNode dummy = new ListNode(0);
        pre = dummy;
        ListNode curr = slow;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = tmp;
        }
        
        ListNode curr2 = dummy.next;
        curr = head;
        
        while (curr2 != null) {
            ListNode next1 = curr.next;
            ListNode next2 = curr2.next;
            
            curr.next = curr2;
            curr2.next = next1;
            
            curr = next1;
            curr2 = next2;
        }
    }

    public void reorderList(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        
        ListNode pre = null;
        curr = head;
        for (int i = 0; i < size-size/2; i++) {
            pre = curr;
            curr = curr.next;
        }
        if (pre != null) pre.next = null;
        
        // reversr list from curr;
        ListNode dummy = new ListNode(0);
        pre = dummy;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = tmp;
        }
        
        ListNode curr2 = dummy.next;
        curr = head;
        
        while (curr2 != null) {
            ListNode next1 = curr.next;
            ListNode next2 = curr2.next;
            
            curr.next = curr2;
            curr2.next = next1;
            
            curr = next1;
            curr2 = next2;
        }
    }

}
