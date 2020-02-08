public class LinkedQueue<T> {
    private int size;
    private LinkedNode<T> rearNode;
    private LinkedNode<T> frontNode;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> rearNode() {
        return rearNode;
    }

    public void setRearNode(LinkedNode<T> rearNode) {
        this.rearNode = rearNode;
    }

    public LinkedNode<T> frontNode() {
        return frontNode;
    }

    public void setFrontNode(LinkedNode<T> frontNode) {
        this.frontNode = frontNode;
    }

    public LinkedQueue(){
        this.setSize(0);
        this.setFrontNode(null);
        this.setRearNode(null);
    }

    public boolean isEmpty(){
        return (this.frontNode() == null) && this.rearNode() == null;
    }

    public boolean isFull(){
        return false;
    }

    public T front(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T frontElement = this.frontNode().element();
            return frontElement;
        }
    }

    public T rear(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T rearElement = this.rearNode().element();
            return rearElement;
        }
    }

    public boolean enQueue(T anElement){
        LinkedNode<T> newRearNode = new LinkedNode(anElement);
        if(this.isEmpty()){
            this.setFrontNode(newRearNode);
        }
        else{
            this.rearNode().setNext(newRearNode);
        }
        this.setRearNode(newRearNode);
        this.setSize(this.size + 1);
        return true;
    }

    public T deQueue(){
        T frontElement = null;
        if(!this.isEmpty()){
            frontElement = this.frontNode().element();
            this.setFrontNode(this.frontNode().next());
            if(this.frontNode() == null){
                this.setRearNode(null);
            }
            this.setSize(this.size() - 1);
        }
        return frontElement;
    }
}
