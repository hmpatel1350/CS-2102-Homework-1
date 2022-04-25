package HW_4;

class MtBT implements IBinTree {
    MtBT(){}

    @Override
    public IBinTree getLeft() {
        return null;
    }

    @Override
    public IBinTree getRight() {
        return null;
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
}
