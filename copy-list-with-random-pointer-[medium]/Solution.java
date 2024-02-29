import java.util.HashMap;
import java.util.Map;

class Solution {
    public static Node copyRandomList(Node head) {

        Map<Node, Node> map = new HashMap<>();  

        Node current = head;

        while(current != null) {
            Node copy = new Node(current.val);
            map.put(current, copy);
            current = current.next;
        }

        current = head;
        while(current != null) {
            Node copy = map.get(current);
            copy.next = map.getOrDefault(current.next, null);
            copy.random = map.getOrDefault(current.random, null);

            current = current.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.next = new Node(13);
        root.random = null;
        root.next.next = new Node(11);
        root.next.random = root;
        root.next.next.next = new Node(10);
        root.next.next.random = root.next.next;
        root.next.next.next.next = new Node(1);
        root.next.next.next.random = root;

        /* just do two passes of the original */

        System.out.println(copyRandomList(root));
    }
}
