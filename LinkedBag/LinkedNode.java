public class LinkedNode<T> {
    private T element;
    private LinkedNode<T> next;

    public T Element() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinkedNode<T> Next() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }
    public LinkedNode(){
        this.setElement(null);
        this.setNext(null);
    }

    public LinkedNode(T anElement){
        this.setElement(anElement);
        this.setNext(null);
    }

    public LinkedNode(T anElement,LinkedNode<T> nextNode){
        this.setElement(anElement);
        this.setNext(nextNode);
    }

}
