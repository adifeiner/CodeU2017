public class BinaryTree<T> {

    private BinaryTreeNode<T> root;

    public BinaryTree(T data) {
        this.root = new BinaryTreeNode(data);
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    // Check if the key exists in the tree
    public Boolean isExist(T key) {
        return isExist(root, key);
    }

    // Recursively check if the key exists in the tree (receives root)
    public Boolean isExist(BinaryTreeNode<T> root, T key) {

        if (root == null){
            return false;
        }
        if (root.getData().equals(key)) {
            return true;
        }

        if (root.getLeftChild() != null) {
            if (isExist(root.getLeftChild(), key)) {
                return true;
            }
        }

        if (root.getRightChild() != null) {
            if (isExist(root.getRightChild(), key)) {
                return true;
            }
        }
        return false;
    }


    // The function searches the node with the key, if the key exists the function
    // return it, otherwise, return null
    public BinaryTreeNode<T> findNode(T key) {
        if (this.isExist(key)) {
            return findNode(root, key);
        }
        System.out.println("The node doesn't exist");
        return null;
    }

    // Recursively searches the node with the key and return it
    public BinaryTreeNode<T> findNode (BinaryTreeNode<T> node, T key){

        if (node == null) {
            return null;
        }

        if (node.getData().equals(key)) {
            return node;
        }

        BinaryTreeNode<T> foundNode = findNode(node.getLeftChild(), key);

        if (foundNode == null) {
            foundNode = findNode(node.getRightChild(), key);
        }
        return foundNode;
    }

    // The function create a left (left or right) to the node with the value parent
    public void insert(T value, T parent, boolean toLeft) {

        // Check if this value already exists in the tree
        if (this.isExist(value)) {
            System.out.println("This value already exists");
            return;
        }

        // Check if the parent exists in the tree
        if (!this.isExist(parent)) {
            System.out.println("This parent isn't exist in the tree");
            return;
        }

        insert(value, this.findNode(parent), toLeft);
    }

    // The function create a left (left or right) to the parent node
    public void insert(T value, BinaryTreeNode<T> parent, boolean toLeft) {

        if (toLeft) {
            if (parent.getLeftChild() == null) {
                parent.setLeftChild(value);
            } else {
                System.out.println("There is already left child");
                return;
            }
        } else {
            if (parent.getRightChild() == null) {
                parent.setRightChild(value);
            } else {
                System.out.println("There is already right child");
                return;
            }
        }
    }
}
