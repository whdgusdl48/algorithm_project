public class ArraySet<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private int size;
    private int capacity;
    private T[] element;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] element() {
        return element;
    }

    public void setElement(T[] element) {
        this.element = element;
    }

    public ArraySet(){
        this.setCapacity(DEFAULT_CAPACITY);
        this.setSize(0);
        this.setElement((T[]) new Object[100]);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return this.size() == this.capacity();
    }

    public boolean doesContain(T anElement){
        boolean found = false;
        int i;
        for(i=1;i<this.size() && !found;i++){
            if(this.element[i].equals(anElement)){
                found = true;
            }
        }
        return found;
    }
    public T get(){
        return this.element()[0];
    }

    public boolean add(T anElement){
        if(this.isFull()){
            return false;
        }
        else{
            if(!this.doesContain(anElement)) {
                this.element()[this.size()] = anElement;
                this.setSize(this.size() + 1);
                return true;
            }
        }
        return false;
    }

    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T removeElement = this.element()[this.size];
            this.element()[this.size] = null;
            this.setSize(this.size - 1);
            return removeElement;
        }
    }

    public boolean remove(T anElement){
        if(this.isEmpty()){
            return false;
        }
        else{
            int i = 0;
            while(i<this.element.length){
                if(this.element()[i].equals(anElement)) {
                    this.element()[i] = null;
                }
            }
            for(int j = i; j<this.size()-1;j++){
                this.element()[j] = this.element()[j+1];
            }
            this.setSize(this.size() -1);
            return true;
        }
    }

    public void clear(){
        for(int i = 0; i<this.element.length;i++){
            this.element()[i] = null;
        }
        this.setSize(0);
    }
}
