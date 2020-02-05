public class LinkedSet<T> {
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

    public LinkedSet(){
        this.setSize(0);
        this.setHead(null);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean doesContain(T anElement){
        boolean found = false;
        LinkedNode<T> current = this.head();
        while(current != null && !found){
            if(current.Element().equals(anElement)){
                found = true;
            }
            else{
                current = current.Next();
            }
        }
        return found;
    }

    public T any(){
        return this.head().Element();
    }

    public boolean add(T anElement){
        if(this.isFull()){
            return false;
        }
        else{
            if(!doesContain(anElement)){
                LinkedNode<T> addNode = new LinkedNode<T>(anElement,this.head());
                this.setSize(this.size()+1);
                this.setHead(addNode);
                return true;
;            }
        }
        return false;
    }

    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T removeElement = this.head().Element();
            this.setHead(this.head().Next());
            this.setSize(this.size() - 1);
            return removeElement;
        }
    }

    public boolean remove(T anElement){
        if(this.isEmpty()){
            return false;
        }
        else{
            LinkedNode<T> previous = null;
            LinkedNode<T> current = this.head();
            boolean found = false;
            while(current != null){
                if(current.Element().equals(anElement)){
                    found = true;
                }
                previous = current;
                current = current.Next();
            }

            if(!found){
                return false;
            }
            else{
                if(current==this.head()){
                    this.setHead(this.head().Next());
                }
                else{
                    previous.setNext(current.Next());
                }
                this.setSize(this.size() - 1);
                return true;
            }
        }
    }
}
