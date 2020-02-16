public class MaxHeap {

    //array!!
    private static final int DEFAULT_CAPACITY = 100;
    private static final int Root = 1;
    private int capacity;
    private int size;
    private int[] heap;

    public int capacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public int[] heap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MaxHeap(){
        this.setCapacity(MaxHeap.DEFAULT_CAPACITY);
        this.setHeap(new int[101]);
        this.setSize(0);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return this.size() == this.capacity();
    }

    public int max(){
        if(this.isEmpty()){
            return -1;
        }
        else{
            return this.heap()[MaxHeap.Root];
        }
    }
    // 루트값과 비교를 하면서 찾아간다. 최대힙이기때문에 비교를 하면서 삽입한다.
    public boolean add(int anElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.setSize(this.size() + 1);//사이즈 하나 증가
            int i = this.size();// 현재 사이즈값을 i로 삼아서
            while((i>MaxHeap.Root) && (anElement > this.heap()[i/2])) {
                //사이즈가 루트보다 작고 비교를 통해서 삽입값이 만약에 힙구조에 있는배열보다 크게되면 반복문이 멈춘다
                // 그렇지 않으면 반복을 통해서 i를 2로 나누면서 값을 찾아간다.
                this.heap()[i] = this.heap()[i / 2];
                i /= 2;
            }
            this.heap()[i] = anElement;
            return true;
        }
    }

    public int removeMax(){
        if(this.isEmpty()){
            return  -1;
        }//비어있다면 null을 반환
        else{
            //과정 : 루트를 먼제 삭제하고 마지막 원소를 루트로 보내고 값을 비교하면서 적절한 위치에 삽입
            int element = this.heap()[MaxHeap.Root];//루트값의 원소를 빼낸다
            this.setSize(this.size() -1);//사이즈 하나 감소
            if(this.size() > 0){//만약 원소가 하나 이상 남아있다면
                int lastElement = this.heap()[this.size() + 1];//마지막 원소를 가지고온다.
                int parent = MaxHeap.Root;//루트로 초기값 설정
                int biggerChild;//찾아 내려갈 변수
                while((parent * 2) <= this.size()){//찾아 내려갈 변수가 사이즈보다 크게되면 반복문 종료
                    biggerChild = parent*2;//루트부터 생각해보면 자식은 *2의 위치에 있게된다.
                    if((biggerChild < this.size()) && (this.heap()[biggerChild] < (this.heap()[biggerChild + 1]))){
                        biggerChild++;
                    }
                    //만약 내려간 값이 사이즈보다 작고 biggerChild 위치의 원소값이 옆에 있는 값과 비교해서 만약 더 작다면 biggerChild를 1 증가
                    if(lastElement >= (this.heap()[biggerChild])){
                        break;
                    }
                    //만약 마지막원소가 BiggerChild 위치 원소와 비교해서 크거나 같으면 반복문을 강제 종료
                    this.heap()[parent] = this.heap()[biggerChild];// 두 조건이 만족하지 못했다면 반복문을 계속돌게한다.
                    parent = biggerChild;//아래로 내려가게함
                }
                this.heap()[parent] = lastElement;//parent 위치에 lastElement삽입
            }
            this.heap()[this.size()+1] = 0;
            return element;
        }
    }
}
