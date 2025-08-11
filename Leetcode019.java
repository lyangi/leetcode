public class Leetcode019 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode left = dummyNode;
        ListNode right = dummyNode;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummyNode.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }
}
