public class ArrayQueue<T> {
    private static final int DEFAULT_CAPACITY = 50 ;
    private int capacity ;
    private int frontPosition ;
    private int rearPosition ;
    private T[] elements ;

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int frontPosition() {
        return frontPosition;
    }

    public void setFrontPosition(int frontPosition) {
        this.frontPosition = frontPosition;
    }

    public int rearPosition() {
        return rearPosition;
    }

    public void setRearPosition(int rearPosition) {
        this.rearPosition = rearPosition;
    }

    public T[] elements() {
        return elements;
    }

    public void setElements(T[] elements) {
        this.elements = elements;
    }

    public ArrayQueue(){
        this.setFrontPosition(0);
        this.setRearPosition(0);
        this.setCapacity(DEFAULT_CAPACITY);
        this.setElements((T[]) new Object[DEFAULT_CAPACITY]);
    }

    public boolean isEmpty(){
        return this.rearPosition() == this.frontPosition();
    }

    public boolean isFull(){
        return this.rearPosition() == this.capacity()-1;
    }

    public int size(){
        return this.rearPosition() - this.frontPosition();
    }

    public T front(){
        return this.elements()[this.frontPosition()+1];
    }

    public T rear(){
        return this.elements()[this.rearPosition()];
    }

    public boolean enQueue(T anElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.setRearPosition(this.rearPosition() + 1);
            this.elements()[this.rearPosition()] = anElement;
            return true;
        }
    }

    public T deQueue(){
        if(this.isEmpty()){
            return null;
        }
        else{
            this.setFrontPosition(this.frontPosition() + 1);
            T frontElement = this.elements()[this.frontPosition()];
            this.elements()[this.frontPosition()] = null;
            return frontElement;
        }
    }
}
