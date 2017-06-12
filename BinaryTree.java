import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {
    private final BinaryTreeNode<T> root;

    public enum InsertChild {LEFT, RIGHT};

    public BinaryTree(T data) {
        this.root = new BinaryTreeNode(data);
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    // The function create a left (left or right) to the node with the value parent
    public void insert(T value, T parent, InsertChild childSide) {
        // Check if this value already exists in the tree
        if (this.root.containsKey(value)) {
            System.err.println("This value already exists");
            return;
        }

        // Check if the parent exists in the tree
        if (!this.root.containsKey(parent)) {
            System.err.println("This parent isn't exist in the tree");
            return;
        }
        insert(value, this.root.findNode(parent), childSide);
    }

    // The function create a left (left or right) to the parent node
    public void insert(T value, BinaryTreeNode<T> parent, InsertChild childSidet) {
        if (childSidet.equals(InsertChild.LEFT)) {
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

    // Prints all the ancestors of the key from the root
    public void printAncestors(T key) {
        List<T> ancestors = findAncestors(key);
        if (ancestors != null) {
            for (T ancestor : ancestors) {
                System.out.print(ancestor + " ");
            }
        }
    }

    public List<T> findAncestors (T key) {
        if (this == null) {
            System.err.println("The tree is empty");
            return null;
        }

        if (!this.root.containsKey(key)) {
            System.err.println("There is no such key in the tree");
            return null;
        }
        List<T> ancestors = new ArrayList<T>();
        ancestors = findAncestors(ancestors, this.root, key);

        return ancestors;
    }

    public List<T> findAncestors (List<T> ancestors, BinaryTreeNode<T> node, T key) {
        if (node.getData() == key) {
            return ancestors;
        }

        if (node.containsKey(key)) {
            ancestors.add(0, node.getData());

            if (node.getRightChild().containsKey(key)) {
                findAncestors(ancestors, node.getRightChild(), key);
            }

            if (node.getLeftChild().containsKey(key)) {
                findAncestors(ancestors, node.getLeftChild(), key);
            }
        }
        return ancestors;
    }

    // The function receives two keys
    // Return the key of the lowest common ancestor
    public T lowestCommonAncestor(T firstKey, T secondKey) {
        if (this == null || !this.root.containsKey(firstKey) || !this.root.containsKey(secondKey)) {
            System.err.println("Invalid input");
            return null;
        }

        if (firstKey.equals(secondKey)) {
            System.err.println("Both nodes are identical, invalid input");
            return null;
        }

        if (this.root.getData().equals(firstKey) || this.root.getData().equals(secondKey)) {
            return this.root.getData();
        }
        List<T> ancestorsFirstKey = findAncestors(firstKey);
        List<T> ancestorsSecondKey = findAncestors(secondKey);

        for (T ancestor : ancestorsFirstKey) {
            if (ancestorsSecondKey.contains(ancestor)) {
                return ancestor;
            }
        }
        return null;
    }
}