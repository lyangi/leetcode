public class Leetcode024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0, head);
        ListNode p0 = dummyNode;

        ListNode pre = null;
        ListNode cur = p0.next;
        while (cur != null && cur.next != null) {
            for (int i = 0; i < 2; i++) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;
        }
        return dummyNode.next;
    }
}
