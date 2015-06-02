package wangheng.leetcode;

public class IntersectionOfTwoLinkedListSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode currA = headA, currB = headB;
        boolean finishedA = false, finishedB = false;
        while (currA != null && currA != currB) {
            currA = currA.next;
            currB = currB.next;
            
            if (currA == null && !finishedA) {
                currA = headB;
                finishedA = true;
            }
            
            if (currB == null && !finishedB) {
                currB = headA;
                finishedB = true;
            }
        }
        return currA;
    }

}
