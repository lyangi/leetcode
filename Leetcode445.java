public class Leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l3 = add(l1, l2);
        return reverse(l3);
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

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode p0 = dummyNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            p0.next = new ListNode(sum % 10);
            p0 = p0.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry != 0) {
            p0.next = new ListNode(carry);
        }
        return dummyNode.next;
    }
}
