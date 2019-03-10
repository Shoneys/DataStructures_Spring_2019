public class AVL<T extends Comparable<? super T>> {

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

    public int height() {
        return height(root);
    }

    public void insert(T item) {
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

//        commented out: if we don't re-balance, we need to update the height.
//        subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
//        return subtree;

        // re-balance
        return balance(subtree);
    }

    private TreeNode<T> balance(TreeNode<T> node) {
        int balance = height(node.left) - height(node.right);
        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        node.height = 1 + Math.max(height(node.right), height(node.left));
        return node;
    }

    private int height(TreeNode<T> subtree) {
        if (subtree == null) {
            return -1;
        }

        return subtree.height;
    }

    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, TreeNode<T> subtree) {
        // 3 cases:
        // hidden case 0: subtree is null

        int comparison = item.compareTo(subtree.data);

        if (comparison == 0) {
            return true;
        }

        if (comparison < 0) {
            return contains(item, subtree.left);
        }

        return contains(item, subtree.right);
    }

    public void remove(T item) {
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

//        commented out: if we don't re-balance, we need to update the height.
//        subtree.height = 1 + Math.max(height(subtree.left), height(subtree.right));
//        return subtree;
        return balance(subtree);
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