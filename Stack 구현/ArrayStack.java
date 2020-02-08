public class ArrayStack<T> {
    private int size;
    private int capacity;
    private T[] elements;

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

    public T[] elements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public ArrayStack(){
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

    public boolean push(T anElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.elements()[this.size()] = anElement;
            this.setSize(this.size() + 1);
            return true;
        }
    }

    public T pop(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T popElement = this.elements()[this.size()-1];
            this.elements()[this.size()-1] = null;
            this.setSize(this.size() - 1);
            return popElement;
        }
    }

    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        else{
            return this.elements()[this.size()-1];
        }
    }

    public void clear(){
        this.setSize(0);
        for(int i = 0; i<this.size();i++){
            this.elements()[i] = null;
        }
    }
}
