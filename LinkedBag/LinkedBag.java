public class LinkedBag<T> {
    private int size;
    private LinkedNode<T> head;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LinkedNode<T> Head() {
        return head;
    }

    public void setHead(LinkedNode<T> head) {
        this.head = head;
    }

    public LinkedBag(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean doesContain(T anElement){
        LinkedNode<T> doesNode = this.Head();
        while(doesNode != null){
            if(doesNode.Element().equals(anElement)){
                return true;
            }
            doesNode = doesNode.Next();
        }
        return false;
    }

    public int frequencyOf(T anElement){
        LinkedNode<T> current = this.Head();
        int count = 0;
        while(current != null){
            if(current.Element().equals(anElement)){
                count++;
            }
            current = current.Next();
        }
        return count;
    }

    public T elementAt(int anOrder){
        if((anOrder < 0) || anOrder >= this.size()){
            return null;
        }
        else {
            LinkedNode<T> current = this.Head();
            for(int i = 0 ; i<anOrder ; i++){
                current = current.Next();
            }
            return current.Element();
        }
    }

    public T any(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return this.Head().Element();
        }
    }

    public boolean add(T addElement) {
        if (this.isFull()) {
            return false;
        }
        else{
            LinkedNode<T> addNode = new LinkedNode<T>(addElement);
            addNode.setNext(this.Head());
            this.setHead(addNode);
            this.setSize(this.size() + 1);
            return true;
        }
    }

    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }
        else{
            LinkedNode<T> removeNode = this.Head();
            this.setHead(removeNode.Next());
            this.setSize(this.size() - 1);
            return removeNode.Element();
        }
    }

    public boolean remove(T removeElement){
        if(this.isEmpty()){
            return false;
        }
        else{
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.Head();
            boolean found = false;
            while(current != null && !found){
                if(current.Element().equals(removeElement)){
                    found = true;
                }
                else {
                    previous = current;
                    current = current.Next();
                }
            }
            if(!found){
                return false;
            }
            else{
                if(current == this.Head()){
                    this.setHead(this.Head().Next());
                }
                else{
                    previous.setNext(current.Next());
                }
                this.setSize(this.size() - 1);
                return true;
            }
        }
    }
    public void clear() {
        this.setSize (0);
        this.setHead (null);
    }

}
