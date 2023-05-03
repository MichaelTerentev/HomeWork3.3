public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.put(3);
        tree.put(11);
        tree.put(69);
        tree.put(121);
        tree.remove(121);
        tree.print();
    }
}
