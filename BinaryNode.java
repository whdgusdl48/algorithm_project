public class BinaryNode<T> {
    private T element;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;

    public T element() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryNode<T> leftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode<T> rightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryNode(){
        this.setElement(null);
        this.setLeftChild(null);
        this.setRightChild(null);
    }

    public BinaryNode ( T  givenElement, BinaryNode<T> givenLeftChild, BinaryNode<T> givenRightChild ){
        this.setElement(givenElement);
        this.setLeftChild(givenLeftChild);
        this.setRightChild(givenRightChild);
    }

    public boolean hasLeftChild(){
        return this.leftChild() != null;
    }

    public boolean hasRightChild(){
        return this.rightChild() != null;
    }

    public boolean isLeaf(){
        return (this.leftChild() == null && this.rightChild() == null);
    }


}
