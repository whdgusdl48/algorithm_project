public class LinkedStack<T> {
    private int size;
    private LinkedNode<T> head;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> head() {
        return head;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public LinkedStack(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean push(T anElement){
        LinkedNode<T> pushNode = new LinkedNode(anElement);
        LinkedNode<T> current = this.head();
        if(this.size() == 0){
            this.setHead(pushNode);
            this.setSize(this.size() + 1);
            return true;
        }
        else {
            while (current.next() != null) {
                current = current.next();
            }
            this.setSize(this.size() + 1);
            current.setNext(pushNode);
            return true;
        }
    }

    public T pop(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T popElement = null;
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.head();
            while(current.next()!=null){
                previous = current;
                current=current.next();
            }
            popElement = current.element();
            previous.setNext(current.next());
            this.setSize(this.size() - 1);
            return popElement;
        }
    }

    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        else{
            LinkedNode<T> current = this.head();
            while(current.next() != null){
                current = current.next();
            }
            if(current == this.head()){
                return this.head().element();
            }
            else {
                return current.element();
            }
        }
    }
}
