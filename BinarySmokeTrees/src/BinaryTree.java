public class BinaryTree<T extends Comparable<? super T>> {

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T d, TreeNode<T> l, TreeNode<T> r) {
            data = d;
            left = l;
            right = r;
        }
    }

    private TreeNode<T> root;

    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        }

        printTree(root);
    }

    private void printTree(TreeNode<T> tree) {
        if (tree != null) {
            printTree(tree.left);
            System.out.println(tree.data);
            printTree(tree.right);
        }
    }

    public void insert(T item) {
        root = insert(root, item);
    }

    private TreeNode<T> insert(TreeNode<T> subtree, T item) {
        if (subtree == null) {
            return new TreeNode<T>(item, null, null);
        }

        int comparison = item.compareTo(subtree.data);

        if (comparison < 0) {
            subtree.left = insert(subtree.left, item);
        } else if (comparison > 0) {
            subtree.right = insert(subtree.right, item);
        }

        return subtree;
    }

    public boolean contains(T item) {
        // TODO: implement
        return false;
    }

    public boolean remove(T item) {
        // TODO: implement
        // return true if we can remove it
        // return false if we can't (ie it's not here)
        return false;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void listAll(int depth){
        ;
    }
}

