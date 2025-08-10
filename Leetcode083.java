public class Leetcode083 {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 1 1 1
        while (head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
            
        }
        return dummyNode.next;
    }
}
