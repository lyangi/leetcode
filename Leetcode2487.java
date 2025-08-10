public class Leetcode2487 {
    public ListNode removeNode(ListNode head) {
        if (head == null || head.next == null) return head;
        head = reverse(head);
        ListNode cur = head;
        while (cur.next != null) {
            int val = cur.val;
            if (cur.next.val < val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next= pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
