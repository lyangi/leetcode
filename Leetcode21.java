
/**
 * Leetcode21
 */
public class Leetcode21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                current.next = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                list1 = list1.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }

    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // base case
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // Recursive case
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode list2 = new ListNode(0);
        ListNode list1 = null;
        ListNode node = mergeTwoLists(list1, list2);
        while (node != null) {
            System.err.println(node.val + "\n");
            node = node.next;
        }
    }
}
