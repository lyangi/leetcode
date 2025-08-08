public class Leetcode2816 {
    public ListNode doubleIt(ListNode head) {
        if (head == null) return head;
        head = reverse(head);
        head = doubleNumber(head);
        return reverse(head);
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

    private ListNode doubleNumber(ListNode head) {
        ListNode dummyNode = new ListNode();
        ListNode p0 = dummyNode;
        int carry = 0;
        while (head != null) {
            int x = head.val * 2 + carry;
            carry = x / 10;
            p0.next = new ListNode(x % 10);
            p0 = p0.next;

            head = head.next;
        }
        if (carry != 0) {
            p0.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
