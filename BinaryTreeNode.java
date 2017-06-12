public class BinaryTreeNode<T> {
    private final T data;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryTreeNode findNode(T key) {
        BinaryTreeNode<T> node = null;

        if (this == null) {
            return null;
        }
        if (this.data.equals(key)) {
            return this;
        }

        if (this.getLeftChild() != null) {
            node = this.getLeftChild().findNode(key);
            if (node != null) {
                return node;
            }
        }

        if (this.getRightChild() != null) {
            node = this.getRightChild().findNode(key);
        }
        return node;
    }

    public boolean containsKey(T key) {
        if (this.findNode(key) != null) {
            return true;
        }
        return false;
    }

    public T getData() {
        return this.data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return this.leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return this.rightChild;
    }

    public void setLeftChild(T data) {
        this.leftChild = new BinaryTreeNode(data);
    }

    public void setRightChild(T data) {
        this.rightChild = new BinaryTreeNode(data);
    }
}

