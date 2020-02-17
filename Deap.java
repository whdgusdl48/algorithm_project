public class Deap {
    private int size;
    private int capacity;
    private int[] element;
    private static final int MaxRoot = 2;
    private static final int MinRoot = 3;
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

    public int[] element() {
        return element;
    }

    public void setElement(int[] element) {
        this.element = element;
    }

    public Deap(){
        this.setSize(0);
        this.setCapacity(101);
        this.setElement(new int[101]);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return this.size() == this.capacity();
    }

    public int Max(){
        if(this.isEmpty()){
            return -1;
        }
        else{
            return this.element()[2];
        }
    }

    public int Min(){
        if(this.isEmpty()){
            return -1;
        }
        else{
            return this.element()[3];
        }
    }
    public int height(int anElement){
        if(this.isEmpty()){
            return -1;
        }
        else{
            int i = 1;
            int height = 1;
            boolean found = false;
            for(;i<this.size(); i++){
                if(anElement == this.element()[i]){
                    found = true;
                    break;
                }
            }
            while(i >=2){
                height++;
                i/=2;
            }
            return height;
        }
    }
    public boolean addMaxHeap(int anElement){
        if(this.isFull()){
            return false;
        }
        else{
            this.setSize(this.size() + 1);
            int i = this.size();
            if(i == 1){
                this.element()[2] = anElement;
                return true;
            }else {
                while ((i >= 2) && (anElement > this.element()[i / 2])) {
                    if(i/2 == 1){
                        int temp = this.element()[2];
                        this.element()[2] = anElement;
                        this.element()[i] = temp;
                        return true;
                    }
                    this.element()[i] = this.element()[i / 2];
                    i /= 2;
                }
                this.element()[i] = anElement;
                return true;
            }
        }
    }

    public boolean addMinHeap(int anElement){
        if(this.isFull()){
            return false;
        }
        else {
            this.setSize(this.size() + 1);
            int i = this.size();
            if (i == 1) {
                this.element()[3] = anElement;
            } else {
                while ((i < 3) && (anElement <= this.element()[i / 2])) {
                    this.element()[i] = this.element()[i / 2];
                    i /= 2;
                }
                this.element()[i] = anElement;
                return true;
            }
            return false;
        }
    }

    public int removeMax(){
        if(this.isEmpty()){
            return -1;
        }
        else{
            int element = this.element()[MaxRoot];
            this.setSize(this.size()-1);
            if(this.size() > 0){
                int min = 1;
                int lastIndex = 1;
                    for(int i = 1 ; i<=this.height(this.size()) - 1 ; i++){
                        min = min * 2;
                        lastIndex = min*2-1;
                    }
                int max = (min + lastIndex) / 2;
                int lastElement= 0;
                    for(int i = min; i<=max;i++){
                        if(this.element()[i] != 0){
                        lastElement = this.element()[i];
                        }
                    }
                int parent = MaxRoot;//루트로 초기값 설정
                int biggerChild;//찾아 내려갈 변수
                while((parent * 2) <= this.size()){//찾아 내려갈 변수가 사이즈보다 크게되면 반복문 종료
                    biggerChild = parent*2;//루트부터 생각해보면 자식은 *2의 위치에 있게된다.
                    if((biggerChild < this.size()) && (this.element()[biggerChild] < (this.element()[biggerChild + 1]))){
                        biggerChild++;
                    }
                    //만약 내려간 값이 사이즈보다 작고 biggerChild 위치의 원소값이 옆에 있는 값과 비교해서 만약 더 작다면 biggerChild를 1 증가
                    if(lastElement >= (this.element()[biggerChild])){
                        break;
                    }
                    //만약 마지막원소가 BiggerChild 위치 원소와 비교해서 크거나 같으면 반복문을 강제 종료
                    this.element()[parent] = this.element()[biggerChild];// 두 조건이 만족하지 못했다면 반복문을 계속돌게한다.
                    parent = biggerChild;//아래로 내려가게함
                }
                this.element()[parent] = lastElement;//parent 위치에 lastElement삽입
            }
            this.element()[this.size()+1] = 0;
            return element;
            }
        }


    public int removeMin(){
        if(this.isEmpty()){
            return -1;
        }
        else{
            int element = this.element()[MinRoot];
            this.setSize(this.size()-1);
            if(this.size() > 0){
                int min = 1;
                int lastIndex = 1;
                for(int i = 1 ; i<=this.height(this.size()) - 1 ; i++){
                    min = min * 2;
                    lastIndex = min*2-1;
                }
                min = ((min + lastIndex) / 2) + 1;
                int lastElement= 0;
                for(int i = min+1; i<=lastIndex;i++){
                    if(this.element()[i] != 0){
                        lastElement = this.element()[i];
                    }
                }
                int parent = MinRoot;//루트로 초기값 설정
                int biggerChild;//찾아 내려갈 변수
                while((parent * 2) <= this.size()){//찾아 내려갈 변수가 사이즈보다 크게되면 반복문 종료
                    biggerChild = parent*2;//루트부터 생각해보면 자식은 *2의 위치에 있게된다.
                    if((biggerChild < this.size()) && (this.element()[biggerChild] < (this.element()[biggerChild + 1]))){
                        biggerChild++;
                    }
                    //만약 내려간 값이 사이즈보다 작고 biggerChild 위치의 원소값이 옆에 있는 값과 비교해서 만약 더 작다면 biggerChild를 1 증가
                    if(lastElement >= (this.element()[biggerChild])){
                        break;
                    }
                    //만약 마지막원소가 BiggerChild 위치 원소와 비교해서 크거나 같으면 반복문을 강제 종료
                    this.element()[parent] = this.element()[biggerChild];// 두 조건이 만족하지 못했다면 반복문을 계속돌게한다.
                    parent = biggerChild;//아래로 내려가게함
                }
                this.element()[parent] = lastElement;//parent 위치에 lastElement삽입
            }
            this.element()[this.size()+1] = 0;
            return element;
        }
    }


}
