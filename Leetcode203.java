public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode p0 = dummyNode;
        while (p0.next != null) {
            if (p0.next.val == val) {
                p0.next = p0.next.next;
            } else {
                p0 = p0.next;
            }
        }
        return dummyNode.next;
    }
}
