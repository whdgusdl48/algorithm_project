public class CircularLinkedQueue<T> {
    private int size;
    private LinkedNode<T> rearNode;

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

    public CircularLinkedQueue(){
        this.setSize(0);
        this.setRearNode(null);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return false;
    }

    public T frontElement(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T frontElement = null;
            frontElement = this.rearNode().next().element();
            return frontElement;
        }
    }

    public T rearElement(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T rearElement = null;
            rearElement = this.rearNode().element();
            return rearElement;
        }
    }

    public boolean enQueue(T anElement){
        LinkedNode<T> newRearNode = new LinkedNode(anElement);
        if(this.isEmpty()){
            newRearNode.setNext(newRearNode);
        }
        else{
            newRearNode.setNext(this.rearNode().next());
            this.rearNode.setNext(newRearNode);
        }
        this.setRearNode(newRearNode);
        this.setSize(this.size() + 1);
        return true;
    }

    public T deQueue(){
        T frontElement = null;
        if(this.isEmpty()){
            return null;
        }
        else{
            frontElement = this.rearNode().next().element();
            if(this.rearNode() == this.rearNode().next()){
                this.setRearNode(null);
            }
            else{
                this.rearNode().setNext(this.rearNode().next().next());
            }
            this.setSize(this.size() - 1);
            return frontElement;
        }
    }
}
