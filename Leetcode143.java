public class Leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode mid = findMid(head);
        ListNode head2 = reverse(mid);

        // 1 2 3 4 5

        while (head2.next != null) {
            ListNode nxt1 = head.next;
            ListNode nxt2 = head2.next;
            head.next = head2;
            head2.next = nxt1;

            head = nxt1;
            head2 = nxt2;
        }
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
