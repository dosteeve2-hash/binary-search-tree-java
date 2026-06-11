public class AVLTree {

    // ====================
    // NODE
    // ====================
    class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;

    // ====================
    // HEIGHT
    // ====================
    private int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // ====================
    // ROTATIONS
    // ====================
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // ====================
    // INSERT
    // ====================
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, int data) {

        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);
        else
            return node; // duplicate not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // LL
        if (balance > 1 && data < node.left.data)
            return rightRotate(node);

        // RR
        if (balance < -1 && data > node.right.data)
            return leftRotate(node);

        // LR
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // ====================
    // SEARCH
    // ====================
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node node, int data) {
        if (node == null)
            return false;

        if (node.data == data)
            return true;

        if (data < node.data)
            return searchRec(node.left, data);
        else
            return searchRec(node.right, data);
    }

    // ====================
    // INORDER
    // ====================
    public String getInorder() {
        StringBuilder sb = new StringBuilder();
        inorderRec(root, sb);
        return sb.toString();
    }

    private void inorderRec(Node node, StringBuilder sb) {
        if (node == null) return;
        inorderRec(node.left, sb);
        sb.append(node.data).append(" ");
        inorderRec(node.right, sb);
    }

    // ====================
    // TREE HEIGHT
    // ====================
    public int getHeight() {
        return height(root);
    }
}