public class ArrayBag<T> {
    private int size;
    private int capacity;
    private T[] elements;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getElements() {
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


    public ArrayBag(){
        this.setCapacity(100);
        this.setSize(0);
        this.setElements((T[]) new Object[100]);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return this.capacity == this.size;
    }
    public boolean find(T findElement){
        for(int i = 0; i<this.elements.length;i++){
            if(this.elements[i] == findElement){
                return true;
            }
        }
        return false;
    }

    public int find2(T findElement){
        int findElements = 0;
        for(int i = 0; i<this.elements.length;i++){
            if(this.elements[i] == findElement){
                findElements++;
            }
        }
        return findElements;
    }

    public T get(){
        return this.elements[0];
    }

    public boolean add(T newElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.setSize(this.size() + 1);
            this.elements[this.size] = newElement;
            return true;
        }
    }

    public T remove(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T removeElement = this.elements[this.size];
            this.getElements()[this.size] = null;
            return removeElement;
        }
    }

    public boolean remove2(T removeElement){
        if(this.isEmpty()){
            return false;
        }
        else {
            int i = 0;
            while(i<this.elements.length){
                if(removeElement == this.elements[i]){
                    this.elements[i] = null;
                    this.setSize(this.size()-1);
                }
                i++;
            }
            for(int j = 0; j<this.elements.length;j++){
                if(this.elements[j] == null){
                    for(int k = j;k<this.elements.length-1;k++){
                        this.elements[k] = this.elements[k+1];
                    }
                }
            }
            return true;
        }
    }

    public void clear(){
        for(int i = 0; i<this.elements.length;i++){
            this.elements[i] = null;
        }
        this.setSize(0);
    }
}
