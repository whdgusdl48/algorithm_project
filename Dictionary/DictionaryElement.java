public class DictionaryElement<Key,Obj> {
    private Key key;
    private Obj object;

    public Key key() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Obj object() {
        return object;
    }

    public void setObject(Obj object) {
        this.object = object;
    }

    public DictionaryElement(){
        this.setKey(null);
        this.setObject(null);
    }

    public DictionaryElement(Key givenKey,Obj givenObject){
        this.setKey(givenKey);
        this.setObject(givenObject);
    }


}
