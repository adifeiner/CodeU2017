import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private final BinaryTreeNode<T> root;
    public enum InsertChild {Left, Right};

    private InsertChild m_insertChild = InsertChild.Left;

    public void setInsertChild (InsertChild insertChild) {
        m_insertChild = insertChild;
    }

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
    public BinaryTreeNode exists(T key) {
        return exists(root, key);
    }

    // Recursively check if the key exists in the tree (receives root)
    public BinaryTreeNode exists(BinaryTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (root.getData().equals(key)) {
            return root;
        }
        BinaryTreeNode<T> node = exists(root.getLeftChild(), key);

        if (node == null) {
            node = exists(root.getRightChild(), key);
        }
        return node;
    }


    // The function create a left (left or right) to the node with the value parent
    public void insert(T value, T parent) {
        // Check if this value already exists in the tree
        if (this.exists(value) != null) {
            System.err.println("This value already exists");
            return;
        }

        // Check if the parent exists in the tree
        if (this.exists(parent) == null) {
            System.err.println("This parent isn't exist in the tree");
            return;
        }
        insert(value, this.exists(parent));
    }

    // The function create a left (left or right) to the parent node
    public void insert(T value, BinaryTreeNode<T> parent) {
        if (m_insertChild == InsertChild.Left) {
            if (parent.getLeftChild() == null) {
                parent.setLeftChild(value);
            } else {
                System.err.println("There is already left child");
                return;
            }
        } else {
            if (parent.getRightChild() == null) {
                parent.setRightChild(value);
            } else {
                System.err.println("There is already right child");
                return;
            }
        }
    }

    // The function receives a Binary Tree and a key
    // Prints all the ancestors of the key from the root
    public List<T> printAncestors(BinaryTree<T> tree, T key) {
        if (tree == null) {
            System.err.println("The tree is empty");
            return null;
        }
        BinaryTreeNode root = tree.getRoot();

        if (tree.exists(key) == null) {
            System.err.println("There is no such key in the tree");
            return null;
        }
        List<T> ancestors = new ArrayList<>();
        ancestors = printAncestors(ancestors, root, key);

        for(T ancestor : ancestors) {
            System.out.print(ancestor + " ");
        }
        return ancestors;
    }

    public List<T> printAncestors(List<T> ancestors, BinaryTreeNode<T> root, T key) {
        if (root.getData() == key) {
            return ancestors;
        }

        if (exists(root, key) != null) {
            ancestors.add(0, (T) root.getData());

            if (exists(root.getRightChild(), key) != null) {
                printAncestors(ancestors, root.getRightChild(), key);
            }

            if (exists(root.getLeftChild(), key) != null) {
                printAncestors(ancestors, root.getLeftChild(), key);
            }
        }
        return ancestors;
    }

    // The function receives a Binary Tree and two nodes
    // Return the lowest common ancestor
    public BinaryTreeNode<T> lowestCommonAncestor(BinaryTree<T> tree, BinaryTreeNode<T> firstNode,
                                                  BinaryTreeNode<T> secondNode) {
        BinaryTreeNode<T> root = tree.getRoot();

        if (root == null || firstNode == null || secondNode == null) {
            System.err.println("Invalid input");
            return null;
        }

        if (firstNode.equals(secondNode)) {
            System.err.println("Both nodes are identical, invalid input");
            System.err.println("Both nodes are identical, invalid input");
            return null;
        }

        if (root.equals(firstNode) || root.equals(secondNode)) {
            return root;
        }
        List<T> ancestorsFirstNode = new ArrayList<>();
        ancestorsFirstNode = printAncestors(ancestorsFirstNode, root, firstNode.getData());
        List<T> ancestorsSecondNode = new ArrayList<>();
        ancestorsSecondNode = printAncestors(ancestorsSecondNode, root, secondNode.getData());

        for (T ancestor : ancestorsFirstNode) {
            if (ancestorsSecondNode.contains(ancestor)) {
                return tree.exists(ancestor);
            }
        }
        return null;
    }
}