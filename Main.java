public class Main {

    private static final boolean left = true;
    private static final boolean right = false;

    public static void main(String[] args) {

        // Test the tree from the assignment
        BinaryTree<Integer> myTree = new BinaryTree(16);
        myTree.insert(9, 16 , left);
        myTree.insert(18, 16, right);
        myTree.insert(3, 9, left);
        myTree.insert(14, 9, right);
        myTree.insert(1, 3, left);
        myTree.insert(5, 3, right);
        myTree.insert(19, 18, right);
        printAncestors(myTree, 5);  // 16, 9, 3
        System.out.println();
        System.out.println("Lowest common ancestor: " +
                lowestCommonAncestor(myTree, myTree.findNode(14), myTree.findNode(5)).getData()); //9
    }

    // The function receives a Binary Tree and a key
    // Prints all the ancestors of the key from the root
    public static <T> void printAncestors(BinaryTree<T> tree, T key) {

        if (tree == null) {
            System.out.println("The tree is empty");
            return;
        }

        BinaryTreeNode root = tree.getRoot();

        if (!tree.isExist(key)) {
            System.out.println("There is no such key in the tree");
            return;
        }

        if (root.getData() == key) {
            return;
        }

        if (tree.isExist(key)) {
            System.out.print(root.getData() + " ");

            if (tree.isExist(root.getRightChild(), key)) {
                printAncestors(new BinaryTree(root.getRightChild()), key);
            }

            if (tree.isExist(root.getLeftChild(), key)) {
                printAncestors(new BinaryTree(root.getLeftChild()), key);
            }
        }
    }

    // The function receives a Binary Tree and two nodes
    // Return the lowest common ancestor
    public static <T> BinaryTreeNode<T> lowestCommonAncestor(BinaryTree<T> tree, BinaryTreeNode<T> firstNode,
                                                             BinaryTreeNode<T> secondNode) {

        BinaryTreeNode<T> root = tree.getRoot();

        if (root == null || firstNode == null || secondNode == null) {
            System.out.println("Invalid input");
            return null;
        }

        if (firstNode.equals(secondNode)) {
            System.out.println("Both nodes are identical, invalid input");
            return null;
        }

        if (root.equals(firstNode) || root.equals(secondNode)) {
            return root;
        }

        if (tree.isExist(root.getLeftChild(), firstNode.getData())
                && tree.isExist(root.getLeftChild(), secondNode.getData())) {
            return lowestCommonAncestor(new BinaryTree(root.getLeftChild()), firstNode, secondNode);
        }

        if (tree.isExist(root.getRightChild(), firstNode.getData())
                && tree.isExist(root.getRightChild(), secondNode.getData())) {
            return lowestCommonAncestor(new BinaryTree(root.getRightChild()), firstNode, secondNode);
        }
        return root;
    }
}
