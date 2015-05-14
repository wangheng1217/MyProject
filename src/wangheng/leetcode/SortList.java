package wangheng.leetcode;

public class SortList {

    public static void main(String[] args) {
        SortList solution = new SortList();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(3);
        ListNode node9 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        
        head = solution.sortList3(head);
        System.out.println("" + head.val + head.next.val + head.next.next.val + head.next.next.next.val);
    }
    
    // TODO: quick sort did not pass OJ
    public ListNode sortList3(ListNode head) {
        return quickSort(head).head;
    }
    
    private HeadTail quickSort(ListNode head) {
        if (head == null) return new HeadTail(null, null);
        if (head.next == null) return new HeadTail(head, head);
        
        ListNode dummySmall = new ListNode(0);
        ListNode preSmall = dummySmall;
        ListNode pre = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (curr.val < head.val) {
                preSmall.next = curr;
                preSmall = preSmall.next;
                
                pre.next = curr.next;
                curr.next = null;
                
                curr = pre.next;
            } else {
                curr = curr.next;
                pre = pre.next;
            }
        }
        
        HeadTail ht1 = quickSort(dummySmall.next);
        HeadTail ht2 = quickSort(head.next);
        
        ListNode theHead;
        ListNode theTail;
        
        if (ht1.head == null) {
            theHead = head;
        } else {
            theHead = ht1.head;
            ht1.tail.next = head;
        }
        
        if (ht2.head == null) {
            head.next = null;
            theTail = head;
        } else {
            head.next = ht2.head;
            theTail = ht2.tail;
        }
        
        return new HeadTail(theHead, theTail);
    }
    
    private class HeadTail {
        ListNode head;
        ListNode tail;
        HeadTail(ListNode head, ListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    
    // recursion
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode node1 = head;
        ListNode node2 = slow.next;
        slow.next = null;
        
        return merge(sortList(node1), sortList(node2));
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                pre.next = node1;
                node1 = node1.next;
            } else {
                pre.next = node2;
                node2 = node2.next;
            }
            pre = pre.next;
        }
        
        if (node1 == null) pre.next = node2;
        else pre.next = node1;
        
        return dummy.next;
    }

    // iteration
    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        
        ListNode curr = head;
        int k = 2;
        while (true) {
            
            curr = dummy.next;
            pre = dummy;
            
            while (curr != null) {
                ListNode firstList = curr;
                ListNode secondList = curr;
                for (int i = 0; i < k/2 && secondList != null; i++) {
                    secondList = secondList.next;
                }
                
                if (secondList == null) break;
                
                int pFirst = 0;
                int pSecond = 0;
                ListNode thePre = pre;
                
                while ( (pFirst < k/2) || (secondList != null && pSecond < k/2)) {
                    if (pFirst < k/2 && (secondList == null || pSecond >= k/2 || firstList.val < secondList.val)) {
                        thePre.next = firstList;
                        firstList = firstList.next;
                        pFirst++;
                        thePre = thePre.next;
                    } else {
                        thePre.next = secondList;
                        secondList = secondList.next;
                        pSecond++;
                        thePre = thePre.next;
                    }
                }
                
                thePre.next = secondList;
                pre = thePre;
                curr = secondList;
            }
            
            if (pre == dummy) break;

            k = k*2;
        }
        
        return dummy.next;
    }

}
