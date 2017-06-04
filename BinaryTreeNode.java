public class BinaryTreeNode<T> {
        private final T data;
        private BinaryTreeNode<T> leftChild;
        private BinaryTreeNode<T> rightChild;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
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

