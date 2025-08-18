public class Leetcode117 {
    public Node connect(Node root) {
        Node dummyNode = new Node();
        Node cur = root;
        while (cur != null) {
            dummyNode.next = null;
            Node nxt = dummyNode;
            while (cur != null) {
                if (cur.left != null) {
                    nxt.next = cur.left;
                    nxt = nxt.next;
                }
                if (cur.right != null) {
                    nxt.next = cur.right;
                    nxt = nxt.next;
                }
                cur = cur.next;
            }
            cur = dummyNode.next;
        }
        return root;
    }
}
