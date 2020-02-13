public class Dictionary<Key extends Comparable<Key>,Obj> {
    private int size;
    private BinaryNode<DictionaryElement<Key,Obj>> root;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BinaryNode<DictionaryElement<Key, Obj>> root() {
        return root;
    }

    public void setRoot(BinaryNode<DictionaryElement<Key, Obj>> root) {
        this.root = root;
    }

    public Dictionary(){
        this.setSize(0);
        this.setRoot(null);
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    public boolean isFull(){
        return false;
    }

    public boolean KeyDoesExist(Key aKey){
        return this.keyDoesExistInTree(this.root(),aKey);
    }

    private boolean keyDoesExistInTree(BinaryNode<DictionaryElement<Key,Obj>> aRoot,Key aKey){
        if(aRoot == null){
            return false;
        }
        else{
            if(aKey.compareTo(aRoot.element().key()) == 0){
                return true;
            }
            else if(aKey.compareTo(aRoot.element().key()) < 0){
                return this.keyDoesExistInTree(aRoot.leftChild(),aKey);
            }
            else{
                return this.keyDoesExistInTree(aRoot.rightChild(),aKey);
            }
        }
    }

    public Obj objectForKey(Key aKey){
        boolean found = false;
        BinaryNode<DictionaryElement<Key,Obj>> currentRoot = this.root();
        while(!found && currentRoot != null){
            if(aKey.compareTo(currentRoot.element().key()) == 0){
                found = true;
            }
            else if(aKey.compareTo(currentRoot.element().key()) < 0){
                currentRoot = currentRoot.leftChild();
            }
            else{
                currentRoot = currentRoot.rightChild();
            }
        }

        if(found){
            return currentRoot.element().object();
        }
        else{
            return null;
        }
    }

    public boolean addKeyAndObject(Key aKey,Obj anObject){
        if(this.root() == null){
            this.setRoot(new BinaryNode((new DictionaryElement(aKey,anObject)),null,null));
            this.setSize(this.size() + 1);
            return true;
        }
        else{
            return this.addKeyAndObjectToSubTree(this.root(),aKey,anObject);
        }
    }

    private boolean addKeyAndObjectToSubTree(BinaryNode<DictionaryElement<Key,Obj>> current,Key aKey,Obj anObject){
        if(current.element().key().compareTo(aKey) == 0){
            return false;
        }
        else if(current.element().key().compareTo(aKey) < 0){
            if(current.leftChild() == null){
                DictionaryElement<Key,Obj> elementForAdd = new DictionaryElement(aKey,anObject);
                current.setLeftChild(
                        new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,null,null));
                this.setSize(this.size() + 1);
                return true;
            }
            else{
                return addKeyAndObjectToSubTree(current.leftChild(),aKey,anObject);
            }
        }
        else{
            if(current.rightChild() == null){
                DictionaryElement<Key,Obj> elementForAdd = new DictionaryElement(aKey,anObject);
                current.setRightChild(
                        new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd,null,null));
                this.setSize(this.size() + 1);
                return true;
            }
            else{
                return addKeyAndObjectToSubTree(current.rightChild(),aKey,anObject);
            }
        }
    }

    public Obj removeObjectForKey(Key aKey){
        if(this.isEmpty()){
            return null;
        }
        else {
            Obj removeObject = null;
            if(aKey.compareTo(this.root().element().key()) == 0){
                removeObject = this.root().element().object();
                if((this.root().leftChild() == null) && (this.root().rightChild() == null)){
                    this.setRoot(null);
                }
                else if(this.root().leftChild() == null){
                    this.setRoot(this.root().rightChild());
                }
                else if(this.root().rightChild() == null){
                    this.setRoot(this.root().leftChild());
                }
                else{
                    this.root().setElement(removeRightMostElemetnOfLeftTree(this.root()));
                }
                this.setSize(this.size() - 1);
                return removeObject;
            }
            else{
                return removeObjectForKeyFromSubTree(this.root(),aKey);
            }
        }
    }

    private DictionaryElement<Key,Obj> removeRightMostElemetnOfLeftTree(BinaryNode current){
        BinaryNode<DictionaryElement<Key,Obj>> leftOfCurrent = current.leftChild();
        if(leftOfCurrent.rightChild() == null){
            current.setLeftChild(leftOfCurrent.leftChild());
            return leftOfCurrent.element();
        }
        else{
            BinaryNode<DictionaryElement<Key,Obj>>  parentOfRightMost = leftOfCurrent;
            BinaryNode<DictionaryElement<Key,Obj>>  rightMost = leftOfCurrent.rightChild();
            while ( rightMost.rightChild() != null ){
                parentOfRightMost = rightMost;
                rightMost = rightMost.rightChild();
            }
            parentOfRightMost.setRightChild(rightMost.leftChild());
            return rightMost.element() ;
        }
    }

    private Obj removeObjectForKeyFromSubTree(BinaryNode<DictionaryElement<Key,Obj>> current,Key aKey){
        if(aKey.compareTo(current.element().key()) < 0){
            BinaryNode<DictionaryElement<Key,Obj>> child = null;
            child = current.leftChild();
            if(child == null){
                return null;
            }
            else{
                if(aKey.compareTo(child.element().key()) == 0){
                    Obj removeObject = child.element().object();
                    if(child.leftChild() == null && child.rightChild() == null){
                        current.setLeftChild(null);
                    }
                    else if(child.leftChild() == null){
                        current.setLeftChild(child.rightChild());
                    }
                    else if(child.rightChild() == null){
                        current.setRightChild(child.leftChild());
                    }
                    else{
                        current.setElement(removeRightMostElemetnOfLeftTree(child));
                    }
                    this.setSize(this.size() - 1);
                    return removeObject;
                }
                else{
                    return removeObjectForKeyFromSubTree(child,aKey);
                }
            }
        }
        return null;
    }
    public boolean replaceObjectForKey(Obj objectForReplace, Key aKey){
        boolean found = false;
        BinaryNode<DictionaryElement<Key,Obj>>  currentRoot = this.root();
        while((!found) && (currentRoot != null)){
            if( aKey.compareTo(currentRoot.element().key()) < 0){
                currentRoot = currentRoot.leftChild();
            }else if( aKey.compareTo(currentRoot.element().key()) > 0 ){
                currentRoot = currentRoot.rightChild();
            }
            else {
                found = true;
            }
        }
        if(found){
            currentRoot.element().setObject(objectForReplace);
            return true;
        }
        else {
            return  false ;
        }
    }
}
