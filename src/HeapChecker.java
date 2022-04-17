import java.util.ArrayList;

public class HeapChecker {
    public HeapChecker(){}
    public boolean addEltTester(IHeap original, int ent, IBinTree updated) {
        /*Makes sure ent was added and no other ents were removed*/
        ArrayList<Integer> initial = getElements(original);
        ArrayList<Integer> added = getElements(updated);
        initial.add(ent);
        initial.sort(Integer::compareTo);
        added.sort(Integer::compareTo);
        if(!initial.equals(added))
            return false;

        return isHeap(updated);
    }

    public boolean remMinEltTester(IHeap original, int ent, IBinTree updated) {
        /*Makes sure ent was removed and no other ents were removed*/
        ArrayList<Integer> initial = getElements(original);
        ArrayList<Integer> added = getElements(updated);
        initial.remove(ent);
        initial.sort(Integer::compareTo);
        added.sort(Integer::compareTo);
        if(!initial.equals(added))
            return false;

        return isHeap(updated);
    }

    private ArrayList<Integer> getElements(IBinTree tree){
        ArrayList<Integer> ents = new ArrayList<>();
        addEnts(ents, tree);
        return ents;
    }

    private void addEnts(ArrayList<Integer> ents, IBinTree tree){
        IBinTree left = tree.left();
        IBinTree right = tree.right();
        if(tree.size()>0){
            if(left.size()>0) {
                ents.add(left.data());
                addEnts(ents, left);
            }
            if(right.size()>0) {
                ents.add(right.data());
                addEnts(ents, right);
            }
        }
    }

    private boolean isHeap(IBinTree tree){
        if(tree.size()>0) {
            IBinTree left = tree.left();
            IBinTree right = tree.right();
            if (tree.data() > left.data() && tree.data() > right.data())
                return false;
            if(Math.abs(left.height()- right.height())>1)
                return false;
            return isHeap(left) && isHeap(right);
        }
        return true;
    }
}
