public class CircularQueue<T> {
    private static final int DEFAULT_CAPACITY = 50;
    private int maxLength;
    private int frontPosition;
    private int rearPosition;
    private T[] elements;

    public int maxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
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

    public CircularQueue(int givenCapacity){
       this.setMaxLength(givenCapacity + 1);
       this.setElements((T[]) new Object[DEFAULT_CAPACITY]);
       this.setFrontPosition(0);
       this.setRearPosition(0);
    }

    public boolean isEmpty(){
        return this.frontPosition() == this.rearPosition();
    }

    public boolean isFull(){
        int nextRearPosition = (this.rearPosition() + 1) % this.maxLength();
        return nextRearPosition == this.frontPosition();
    }

    public int size(){
        if(this.frontPosition() <= this.rearPosition()){
            return (this.rearPosition() - this.frontPosition());
        }
        else{
            return(this.rearPosition() + this.maxLength() - this.frontPosition());
        }
    }

    public T front(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T frontElement = null;
            frontElement = this.elements()[this.frontPosition() + 1];
            return frontElement;
        }
    }
    public T rear(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T rearElement = null;
            rearElement = this.elements()[this.rearPosition()];
            return rearElement;
        }
    }

    public boolean enQueue(T anElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.setRearPosition((this.rearPosition() + 1)% this.maxLength());
            this.elements()[this.rearPosition()] = anElement;
            return true;
        }
    }

    public T deQueue() {
        if (this.isEmpty()) {
            return null;
        } else {
            T frontElement = null;
            this.setFrontPosition((this.frontPosition() + 1) % this.maxLength());
            frontElement = this.elements()[this.frontPosition()];
            this.elements()[this.frontPosition()] = null;
            return frontElement;
        }
    }
}
