@SuppressWarnings("unused")
public class BinaryTree {
    Node root;
    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }
    public BinaryTree() {
        this.root = null;
    }
    private Node put(Node current, int value) {
        if(current == null || value == current.value) {
            return new Node(value);
        }
        if(value > current.value) {
            current.right = put(current.right, value);
        }
        else if(value < current.value) {
            current.left = put(current.left, value);
        }
        return current;
    }
    private Node findSmallest(Node current) {
        return current.left == null ? current : findSmallest(current.left);
    }
    private Node remove(Node current, int value) {
        if(current == null) {
            return null;
        }
        if(value == current.value) {
            if(current.left == null && current.right == null) {
                return null;
            }
            if(current.left == null) {
                return current.right;
            }
            if(current.right == null) {
                return current.left;
            }
            Node smallest = findSmallest(current.right);
            current = smallest;
            current.right = remove(current.right, current.value);
            return current;
        }
        if(value < current.value) {
            current.left = remove(current.left, value);
            return current;
        }
        current.right = remove(current.right, value);
        return current;
    }
    private void printTree(Node current) {
        if(current == null)
            return;

        System.out.println(current.value);

        if(current.left != null && current.right != null) {
            printTree(current.left);
            printTree(current.right);
        }
        else if(current.right == null) {
            printTree(current.left);
        }
        else printTree(current.right);
    }
    public void put(int value) {
        if(root == null)
            root = new Node(value);
        put(root, value);
    }
    public void remove(int value) {
        if(value == root.value)
            root = null;
        remove(root, value);
    }
    public void print() {
        printTree(root);
    }
}
