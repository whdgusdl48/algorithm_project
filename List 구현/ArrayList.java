public class ArrayList<T> {
    private int size;
    private int capacity;
    private T[] elements;

    public int capacity(){
        return this.capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] element() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public int size(){
        return size;
    }

    public void setSize(int newSize){
        this.size = newSize;
    }

    public ArrayList(){
        this.setSize(0);
        this.setCapacity(100);
        this.setElements((T[]) new Object[100]);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return this.size() == this.capacity();
    }

    private boolean anElementDoexExistAt(int anOrder){
        return ((anOrder >= 0) && (anOrder < this.size()));
    }

    public T elementAt(int anOrder){
        if(this.anElementDoexExistAt(anOrder)){
            return this.element()[anOrder];
        }
        else{
            return null;
        }
    }

    public T first(){
        return this.element()[0];
    }

    public T last(){
        return this.element()[this.size()];
    }
    public boolean doesContain(T anElement){
        boolean found = false;
        for(int i = 0; i<this.size() && !found;i++){
            if(this.element()[i].equals(anElement)){
                found = true;
            }
        }
        return found;
    }

    public int orderOf(T anElement){
        int order = 0;
        for(int i = 0 ; i<this.size();i++){
            if(this.element()[i].equals(anElement)){
                order = i;
            }
        }
        return order;
    }
    public void makeRoomAt(int order){
        for(int i = order ;i<this.size();i++){
            this.element()[i+1] = this.element()[i];
        }
        this.element()[order] = null;
    }
    public boolean addTo(T anElement,int anOrder){
        if(this.isFull()){
            return false;
        }
        else{
            this.makeRoomAt(anOrder);
            this.element()[anOrder] = anElement;
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
    private void removeGapAt(int order){
        for(int i = order+1 ; i<this.size() ; i++){
            this.element()[i-1] = this.element()[i];
        }
        this.element()[this.size-1] = null;
    }
    public T removeFrom(int anOrder){
        if(this.isEmpty()){
            return null;
        }
        else{
            T removeElement = null;
            if(this.anElementDoexExistAt(anOrder)){
                removeElement = this.element()[anOrder];
                this.removeGapAt(anOrder);
                this.setSize(this.size() - 1);
            }
            return removeElement;
        }
    }
    public T  removeFirst () { return  removeFrom (0) ; }
    public T  removeLast () { return  removeFrom (this.size()-1) ; }
    public T  removeAny () { return  removeLast () ; }

    public boolean replaceAt(T anElement,int anOrder){
        if(this.anElementDoexExistAt(anOrder)){
            this.element()[anOrder] = anElement;
            return true;
        }
        else{
            return false;
        }
    }

    public void  clear(){
        for(int i = 0;i < this.size();i++){
            this.element()[i] = null;
        }
        this.setSize(0);
    }

}
