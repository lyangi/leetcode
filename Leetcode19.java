class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;
   }
}
public class Leetcode19 {
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode = head;
        ListNode p = head;
        while(p.next != null) {
            p = p.next;
        }
        int last = p.val;
        int i = last - n;
        while(head != null && head.val != i) {
            head = head.next;
        }
        if (head != null && head.next.next != null) {
            head.next = head.next.next;
        } else if (head != null){
            head.next = null;
        }
        return dummyNode;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }
}
