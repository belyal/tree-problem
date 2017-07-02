package org.belial.treeproblem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeafSortUtilTest {

    @Test
    public void unionOfTwoChainOfSortedLeavesShouldReturnOneChainOfSortedLeaves() throws Exception {
        Leaf<Integer> leaf1 = new Leaf<>(4, new Leaf<>(6, new Leaf<>(9)));
        Leaf<Integer> leaf2 = new Leaf<>(1, new Leaf<>(3, new Leaf<>(8)));
        Leaf<Integer> union = LeafSortUtil.unionSorted(leaf1, leaf2);
        assertEquals("1 -> 3 -> 4 -> 6 -> 8 -> 9 -> null", union.toString());
    }

    @Test
    public void unionOneChainOfLeavesWithSingleLeafShouldReturnTheSortedLeavesWithThisLeafInIt() throws Exception {
        Leaf<Integer> leaf1 = new Leaf<>(1, new Leaf<>(3, new Leaf<>(4)));
        Leaf<Integer> leaf2 = new Leaf<>(3);
        Leaf<Integer> union = LeafSortUtil.unionSorted(leaf1, leaf2);
        assertEquals("1 -> 3 -> 3 -> 4 -> null", union.toString());
    }

    @Test
    public void unionOfTwoChainOfSortedLeavesThatHaveDifferentValuesShouldReturnChainOfSortedLeaves() throws Exception {
        Leaf<Integer> leaf1 = new Leaf<>(4, new Leaf<>(8, new Leaf<>(9)));
        Leaf<Integer> leaf2 = new Leaf<>(21, new Leaf<>(30, new Leaf<>(33)));
        Leaf<Integer> union = LeafSortUtil.unionSorted(leaf1, leaf2);
        assertEquals("4 -> 8 -> 9 -> 21 -> 30 -> 33 -> null", union.toString());
    }

}