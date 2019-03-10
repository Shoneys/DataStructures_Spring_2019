public class BST<T extends Comparable<? super T>> {

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

    void insert(T item) {
        root = insert(root, item);
    }

    private TreeNode<T> insert(TreeNode<T> subtree, T item) {
        if (subtree == null) {
            return new TreeNode<>(item, null, null);
        }

        int comparison = item.compareTo(subtree.data);

        if (comparison < 0) {
            subtree.left = insert(subtree.left, item);
        } else if (comparison > 0) {
            subtree.right = insert(subtree.right, item);
        }

        // rebalance
        int balance = height(subtree.left) - height(subtree.right);

        subtree.height = 1 + Math.max(height(subtree.right), height(subtree.left));

        return subtree;
    }

    private int height(TreeNode<T> subtree) {
        if (subtree == null) {
            return -1;
        }

        return subtree.height;
    }

    private void remove(T item) {
        // TODO: implement
        root = remove(item, root);
    }

    private TreeNode<T> remove(T item, TreeNode<T> subtree) {
        if (subtree == null) {
            return null;
        }

        int comparison = item.compareTo(subtree.data);
        if (comparison < 0) {
            subtree.left = remove(item, subtree.left);
        } else if (comparison > 0) {
            subtree.right = remove(item, subtree.right);
        } else {
            // we want to remove the subtree node

            // CASE 1: subtree is a leaf

            if (subtree.left == null && subtree.right == null) {
                subtree = null;
            } else if (subtree.left != null && subtree.right == null) {

                // CASE 2: subtree has one child
                subtree = subtree.left;
            } else if (subtree.left == null && subtree.right != null) {
                subtree = subtree.right;
            } else {
                // CASE 3: subtree has two children.
                // replace subtree by its successor
                // then delete its successor.

                TreeNode<T> successor = subtree.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
                subtree.data = successor.data;
                subtree.right = remove(subtree.data, subtree.right);
            }
        }

        subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
        return subtree;
    }

    private boolean isEmpty() {
        return root == null;
    }

    private TreeNode<T> rotateLeft(TreeNode<T> subtree) {
        TreeNode<T> right = subtree.right;
        subtree.right = right.left;
        right.left = subtree;

        // update heights!
        return getTreeNode(subtree, right);
    }

    private TreeNode<T> rotateRight(TreeNode<T> subtree) {
        TreeNode<T> left = subtree.left;
        subtree.left = left.right;
        left.right = subtree;

        // update heights!
        return getTreeNode(subtree, left);
    }

    private TreeNode<T> getTreeNode(TreeNode<T> subtree, TreeNode<T> left) {
        subtree.height = 1 + Math.max(height(subtree.right), height(subtree.left));
        left.height = 1 + Math.max(height(left.left), height(left.right));
        return left;
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;
        int height;

        TreeNode(T d, TreeNode<T> l, TreeNode<T> r) {
            data = d;
            left = l;
            right = r;
            height = 0;
        }
    }

}