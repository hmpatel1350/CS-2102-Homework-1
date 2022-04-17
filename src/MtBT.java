public class MtBT implements IBinTree {
    MtBT() {
    }

    // returns false since empty tree has no elements
    public boolean hasElt(int e) {
        return false;
    }

    // returns 0 since enpty tree has no elements
    public int size() {
        return 0;
    }

    // returns 0 since empty tree has no branches
    public int height() {
        return 0;
    }

    @Override
    public IBinTree left(){
        return new MtBT();
    }

    @Override
    public IBinTree right(){
        return new MtBT();
    }

    @Override
    public int data(){
        return Integer.MAX_VALUE;
    }
}
