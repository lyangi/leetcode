import java.util.HashSet;

public class Leetcode3217 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (nums == null || nums.length == 0) return head;
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode p0 = dummyNode;
        while (p0.next != null) {
            if (set.contains(p0.next.val)) {
                p0.next = p0.next.next;
            } else {
                p0 = p0.next;
            }
        }
        return dummyNode.next;
    }
}
