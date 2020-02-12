public class Tree<T> {
    private BinaryNode<T> root;

    public BinaryNode<T> root() {
        return root;
    }

    public void setRoot(T rootElement) {
        BinaryNode<T> RootNode = new BinaryNode(rootElement,null,null);
        this.root = RootNode;
    }

    public Tree(){
        this.setRoot(null);
    }

    public boolean isEmpty(){
        return this.root() == null;
    }
    public boolean leftAdd(T anElement,BinaryNode<T> root){
        BinaryNode<T> newNode = new BinaryNode(anElement,null,null);
        root.setLeftChild(newNode);
        return true;
    }
    public boolean rightAdd(T anElement,BinaryNode<T> root){
        BinaryNode<T> newNode = new BinaryNode(anElement,null,null);
        root.setRightChild(newNode);
        return true;
    }
    public int height(){
        return this.heightOfSubTree(this.root);
    }

    private int heightOfSubTree(BinaryNode<T> aSubTreeRoot){
        int height = 0;
        if(aSubTreeRoot != null){
            int rightHeight = heightOfSubTree(aSubTreeRoot.rightChild());
            int leftHeight = heightOfSubTree(aSubTreeRoot.leftChild());
            int maxSubTreeHeight = rightHeight >= leftHeight ?  rightHeight : leftHeight;
            height = 1 + maxSubTreeHeight;
        }
        return height;
    }

    public int size(){
        return this.sizeOfSubTree(this.root());
    }

    public int sizeOfSubTree(BinaryNode<T> aSubTreeNode){
        int size = 0;
        if(aSubTreeNode != null){
            int leftSize = this.sizeOfSubTree(aSubTreeNode.leftChild());
            int rightSize = this.sizeOfSubTree(aSubTreeNode.rightChild());
            size = 1 + leftSize + rightSize;
        }
        return size;
    }

    public T rootElement(){
        return this.root().element();
    }

    public Tree leftSubTree(){
        Tree SubTree = new Tree();
        SubTree.setRoot(this.root().leftChild());
        return SubTree;
    }

    public Tree rightSubTree(){
        Tree SubTree = new Tree();
        SubTree.setRoot(this.root().rightChild());
        return SubTree;
    }
    public void visit (T anElement) {
        System.out.println(anElement);
    }
    public  void  inOrderRecursively (BinaryNode<T> aRoot) {
        if ( aRoot != null ) {
            this.inOrderRecursively (aRoot.leftChild());
            this.visit (aRoot.element()) ;
            this.inOrderRecursively (aRoot.rightChild()) ;
        }
    }

}
