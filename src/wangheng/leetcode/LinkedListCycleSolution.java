package wangheng.leetcode;

public class LinkedListCycleSolution {
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) return true;
        }
        
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head, slow = head;

        do {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }

            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        return true;
    }
}
