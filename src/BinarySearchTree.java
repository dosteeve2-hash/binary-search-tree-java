public class BinarySearchTree {

    // ====================
    // NODE
    // ====================
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // ====================
    // CONSTRUCTOR
    // ====================
    public BinarySearchTree() {
        root = null;
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
        else
            node.right = insertRec(node.right, data);

        return node;
    }

    // ====================
    // SEARCH
    // ====================
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;

        if (data < node.data)
            return searchRec(node.left, data);
        else
            return searchRec(node.right, data);
    }

    // ====================
    // INORDER (STRING)
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
    // PREORDER (STRING)
    // ====================
    public String getPreorder() {
        StringBuilder sb = new StringBuilder();
        preorderRec(root, sb);
        return sb.toString();
    }

    private void preorderRec(Node node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.data).append(" ");
        preorderRec(node.left, sb);
        preorderRec(node.right, sb);
    }

    // ====================
    // POSTORDER (STRING)
    // ====================
    public String getPostorder() {
        StringBuilder sb = new StringBuilder();
        postorderRec(root, sb);
        return sb.toString();
    }

    private void postorderRec(Node node, StringBuilder sb) {
        if (node == null) return;
        postorderRec(node.left, sb);
        postorderRec(node.right, sb);
        sb.append(node.data).append(" ");
    }

    // ====================
    // NODE COUNT
    // ====================
    public int getNodeCount() {
        return countRec(root);
    }

    private int countRec(Node node) {
        if (node == null) return 0;
        return 1 + countRec(node.left) + countRec(node.right);
    }

    // ====================
    // HEIGHT
    // ====================
    public int getHeight() {
        return heightRec(root);
    }

    private int heightRec(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(heightRec(node.left), heightRec(node.right));
    }

    // ====================
    // LEAVES (STRING)
    // ====================
    public String getLeaves() {
        StringBuilder sb = new StringBuilder();
        leavesRec(root, sb);
        return sb.toString();
    }

    private void leavesRec(Node node, StringBuilder sb) {
        if (node == null) return;
        if (node.left == null && node.right == null)
            sb.append(node.data).append(" ");
        leavesRec(node.left, sb);
        leavesRec(node.right, sb);
    }
}