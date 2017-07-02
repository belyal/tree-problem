package org.belial.treeproblem;

/**
 * Class that is used to sort the linked list of Leaf objects.
 */
public class LeafSortUtil {

    /**
     * The method returns one combined sorted chain of leaves from two sorted chains of leaves.
     * @param leaf1 first sorted chain of leaves
     * @param leaf2 second sorted chain of leaves
     * @param <T> the type of leaf's value
     * @return a combined sorted chain
     */
    public static <T extends Comparable<T>> Leaf<T> unionSorted(Leaf<T> leaf1, Leaf<T> leaf2) {
        Leaf<T> result;
        Leaf<T> currLeaf;
        if (leaf1.compareTo(leaf2) <= 0) {
            currLeaf = leaf1;
            leaf1 = leaf1.getNext();
        } else {
            currLeaf = leaf2;
            leaf2 = leaf2.getNext();
        }
        result = currLeaf;
        while (leaf1 != null && leaf2 != null) {
            if (leaf1.compareTo(leaf2) <= 0) {
                currLeaf.setNext(leaf1);
                currLeaf = leaf1;
                leaf1 = leaf1.getNext();
            } else {
                currLeaf.setNext(leaf2);
                currLeaf = leaf2;
                leaf2 = leaf2.getNext();
            }
        }
        currLeaf.setNext(leaf1 != null ? leaf1 : leaf2);
        return result;
    }

}
