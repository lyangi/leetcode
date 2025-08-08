public class Leetcode092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        ListNode dummyNode = new ListNode(0, head);
        ListNode p0 = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            p0 = p0.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        p0.next.next = cur;
        p0.next = pre;

        return dummyNode.next;
    }
}
