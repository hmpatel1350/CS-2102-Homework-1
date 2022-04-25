package HW_4;

interface IBinTree {
 // determines whether element is in the tree
 boolean hasElt(int e);
 // returns number of nodes in the tree; counts duplicate elements as separate items
 int size();
 // returns depth of longest branch in the tree
 int height();

 //Left branch
 IBinTree left();

 //Right branch
 IBinTree right();

 //Current node data
 int data();
}

