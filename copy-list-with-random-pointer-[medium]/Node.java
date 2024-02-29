class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @Override
    public String toString() {
        String s = "";

        Node copy = this;
        while(copy != null) {
            s += copy.val;
            if(copy.next != null) 
                s += ", ";
            copy = copy.next;
        }

        return s;
    }
}