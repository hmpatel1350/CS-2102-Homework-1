package HW_4;

import java.util.ArrayList;

public class HeapChecker {
    public HeapChecker(){}

    /**
     *
     * Checks if new bintree is a valid updated heap
     *
     * @param original Original heap
     * @param ent Added value
     * @param updated Updated bintree
     * @return true if valid, false if not
     */
    public boolean addEltTester(IHeap original, int ent, IBinTree updated) {
        /*Makes sure ent was added and no other ents were removed*/
        ArrayList<Integer> initial = getElements(original);
        ArrayList<Integer> added = getElements(updated);
        initial.add(ent); //Adds ent to list of elements in original
        initial.sort(Integer::compareTo); //Sorts elements from least to greatest
        added.sort(Integer::compareTo); //Sorts elements from least to greatest
        if(!initial.equals(added)) { //Checks if lists are identical
            return false;
        }

        return isHeap(updated); //Checks if the bintree is a valid heap
    }

    public boolean remMinEltTester(IHeap original, IBinTree updated) {
        /*Makes sure ent was removed and no other ents were removed*/
        ArrayList<Integer> initial = getElements(original);
        ArrayList<Integer> added = getElements(updated);
        initial.sort(Integer::compareTo);
        initial.remove(0);
        added.sort(Integer::compareTo);
        if(!initial.equals(added))
            return false;

        return isHeap(updated);
    }

    /**
     * Gets all the elements in a bintree
     *
     * @param tree IBintree
     * @return All integers
     */
    private ArrayList<Integer> getElements(IBinTree tree){
        ArrayList<Integer> ents = new ArrayList<>();
        addEnts(ents, tree);
        return ents;
    }

    /**
     * Adds current peak and checks left and right
     *
     * @param ents ArrayList to update
     * @param tree Current Bintree
     */
    private void addEnts(ArrayList<Integer> ents, IBinTree tree){
        IBinTree left = tree.left();
        IBinTree right = tree.right();
        if(tree.size()>0){
            ents.add(tree.data()); //Adds element to list
            if(left.size()>0) {
                addEnts(ents, left); //Checks left if not empty
            }
            if(right.size()>0) {
                addEnts(ents, right); //Checks right if not empty
            }
        }
    }

    /**
     * Determines if tree is a valid Heap
     *
     * @param tree
     * @return
     */
    private boolean isHeap(IBinTree tree){
        if(tree.size()>0) {
            IBinTree left = tree.left();
            IBinTree right = tree.right();
            if (tree.data() > left.data() && tree.data() > right.data()) //If parent node is larger than any children
                return false;
            return isHeap(left) && isHeap(right);
        }
        return true; //If empty automatically valid
    }
}
