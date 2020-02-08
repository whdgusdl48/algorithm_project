public class LinkedBag<T> {
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

    public LinkedBag(){
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
        if(this.isEmpty()){
            return false;
        }
        else{
            LinkedNode<T> current = this.head();
            boolean found = false;
            while(current != null){
                if(current.element().equals(anElement)){
                    found = true;
                }
                current = current.next();
            }
            return found;
        }
    }
    public int frequencyOf(T anElement){
        if(this.isEmpty()){
            return 0;
        }
        else{
            LinkedNode<T> current = this.head();
            int count = 0;
            while(current != null){
                if(current.element().equals(anElement)){
                    count++;
                }
                current = current.next();
            }
            return count;
        }
    }

    public T any(){
        return this.head().element();
    }

    public boolean add(T anElement){
        LinkedNode<T> addNode = new LinkedNode(anElement);
        this.setSize(this.size()+1);
        addNode.setNext(this.head());
        this.setHead(addNode);
        return true;
    }

    public T removeAny(){
        if(this.isEmpty()){
            return null;
        }
        else{
            T removeElement = this.head().element();
            this.setHead(this.head().next());
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
            while(current != null && !found){
                if(current.element().equals(anElement)){
                    found = true;
                }
                else {
                    previous = current;
                    current = current.next();
                }
            }

            if(!found){
                return false;
            }
            else{
                if(current == this.head()){
                    this.setHead(this.head().next());
                }
                else{
                    previous.setNext(current.next());
                }
                this.setSize(this.size()- 1);
                return true;
            }
        }
    }

    public void clear(){
        this.setSize(0);
        this.setHead(null);
    }

    public void printNode(){
        ListIterator a = iterator();
        while(a.hasNext()){
            System.out.println(a.next());
        }
    }
    private class ListIterator implements Iterator<T> {//Iterator를 구현하기 위한 내부클래스 설정
        private LinkedNode<T> _nextNode;//다음 위치 변수 설정

        public LinkedNode<T> nextNode() {
            return _nextNode;
        }

        public void setNextNode(LinkedNode<T> _nextNode) {
            this._nextNode = _nextNode;
        }

        private ListIterator() {
            this._nextNode = head;
        }

        public boolean hasNext() {//interface에 있는 hasNext를 override한다.
            return (this.nextNode() != null);
        }

        public T next() {//다음원소를 넣어주는 메소드
            if (this.nextNode() == null) {
                return null;
            } else {
                T e = this._nextNode.element();
                this._nextNode = this.nextNode().next();
                return e;
            }
        }
    }
    public ListIterator iterator(){//반복자 생성자
        return new ListIterator();
    }
}

