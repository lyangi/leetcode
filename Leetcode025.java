public class Leetcode025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0, head);
        ListNode p0 = dummyNode;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        ListNode pre = null;
        ListNode cur = p0.next;
        for (int i = 0; i < length / k; i++) {
            for (int j = 0; j < k; j++) {
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
