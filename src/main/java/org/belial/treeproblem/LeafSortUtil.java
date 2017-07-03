package org.belial.treeproblem;

import java.util.Stack;

/**
 * Class that is used to sort the linked list of Leaf objects.
 */
public class LeafSortUtil {

    /**
     * The method returns one combined sorted chain of leaves from two sorted chains of leaves.
     * @param leaf1 first sorted chain of leaves
     * @param leaf2 second sorted chain of leaves
     * @return a combined sorted chain
     */
    public static Leaf unionSorted(Leaf leaf1, Leaf leaf2) {
        if (leaf1 == null) {
            return leaf2;
        } else if (leaf2 == null) {
            return leaf1;
        }

        Leaf result;
        Leaf currLeaf;
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

    /**
     * The method sorts the specified leaves into ascending order, according to the
     * {@linkplain Comparable natural ordering} of its elements.
     * @param leaf chain of leaves
     * @return a sorted chain of leaves
     */
    public static Leaf sort(Leaf leaf) {
        SortStackItem currItem = null;
        Stack<SortStackItem> stack = new Stack<>();
        while (leaf != null) {
            currItem = new SortStackItem(1, leaf);
            leaf = leaf.getNext();
            currItem.leaf.setNext(null);

            while (!stack.empty() && stack.peek().level == currItem.level) {
                Leaf intersected = unionSorted(stack.pop().leaf, currItem.leaf);
                currItem = new SortStackItem(currItem.level + 1, intersected);
            }
            stack.push(currItem);
        }
        if (!stack.empty()) {
            currItem = stack.pop();
        }
        while (!stack.empty()) {
            Leaf leaf1 = stack.pop().leaf;
            Leaf intersected = unionSorted(leaf1, currItem.leaf);
            currItem = new SortStackItem(currItem.level + 1, intersected);
        }
        return currItem != null ? currItem.leaf : null;
    }

    private static class SortStackItem {
        final int level;
        final Leaf leaf;

        SortStackItem(int level, Leaf leaf) {
            this.level = level;
            this.leaf = leaf;
        }
    }

}
