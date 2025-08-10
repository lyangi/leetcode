public class Leetcode082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        // 1 2 3 3 4 4 5
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
            
        }
        return dummyNode.next;
    }
}
