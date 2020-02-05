public class LinkedList<T> {
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

    public LinkedList(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean doesContaion(T anElement){
        LinkedNode<T> current = this.head();
        boolean found = false;
        while(current != null && !found){
            if(current.Element().equals(anElement)){
                found = true;
            }
            current = current.Next();
        }
        return found;
    }
    private boolean  anElementDoesExistAt(int anOrder){
        return ( (anOrder >= 0) && (anOrder < this.size()) );
    }

    public T elementAt(int anOrder){
        if(this.anElementDoesExistAt(anOrder)){
            LinkedNode<T> current = this.head();
            int Count = 0;
            while(Count < anOrder){
                current = current.Next();
                Count++;
            }
            return current.Element();
        }
        else{
            return null;
        }
    }

    public T first(){
        return elementAt(0);
    }

    public T last(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return elementAt(this.size() - 1);
        }
    }

    public int orderOf(T anElement){
        int order = 0;
        LinkedNode<T> current = this.head();
        boolean found = false;
        while(current != null && !found){
            if(current.Element().equals(anElement)){
                found = true;
            }
            order++;
        }
        return order;
    }

    public boolean doesContain(T anElement){
        LinkedNode<T> current = this.head();
        while(current != null){
            if(current.Element().equals(anElement)){
                return true;
            }
            current = current.Next();
        }
        return false;
    }
    public boolean addTo(T anElement,int anOrder){
        if(anOrder < 0 || anOrder > this.size()){
            return false;
        }
        else if(this.isFull()){
            return false;
        }
        else{
            LinkedNode<T> addNode = new LinkedNode(anElement);
            if(anOrder == 0){
                addNode.setNext(this.head());
                this.setHead(addNode);
            }
            else{
                LinkedNode<T> previous = this.head();
                for(int i = 1 ; i<anOrder;i++){
                    previous = previous.Next();
                }
                addNode.setNext(previous.Next());
                previous.setNext(addNode);
            }
            this.setSize(this.size() + 1);
            return true;
        }
    }
    public boolean addToFirst(T anElement){
        return this.addTo(anElement,0);
    }

    public boolean addToLast(T anElement){
        return this.addTo(anElement,this.size());
    }

    public T removeFrom(int anOrder){
        if(this.isEmpty()){
            return null;
        }
        else{
            LinkedNode<T> remove = null;
            if(anOrder == 0){
                remove = this.head();
                this.setHead(this.head().Next());
            }
            else{
                LinkedNode<T> previous = this.head();
                for(int i = 1; i<anOrder;i++){
                    previous = previous.Next();
                }
                remove = previous.Next();
                previous.setNext(remove.Next());
            }
            this.setSize(this.size() - 1);
            return remove.Element();
        }
    }
    public T  removeFirst () { return  (this.removeFrom(0)); }
    public T  removeLast () { return  (removeFrom(this.size()-1)); }

    public boolean replaceAt(T anElement,int anOrder){
        if(!this.anElementDoesExistAt(anOrder)){
            return null;
        }
        else{
            LinkedNode<T> current = this.head();
            for(int i = 0; i<anOrder;i++){
                current = current.Next();
            }
            current.setElement(anElement);
            return true;
        }
    }
}
