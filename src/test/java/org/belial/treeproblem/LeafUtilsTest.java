package org.belial.treeproblem;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LeafUtilsTest {

    @Test
    public void unionOfTwoChainOfSortedLeavesShouldReturnOneChainOfSortedLeaves() throws Exception {
        Leaf leaf1 = new Leaf(4, new Leaf(6, new Leaf(9)));
        Leaf leaf2 = new Leaf(1, new Leaf(3, new Leaf(8)));
        Leaf union = LeafUtils.unionSorted(leaf1, leaf2);
        assertEquals("1 -> 3 -> 4 -> 6 -> 8 -> 9 -> null", union.toString());
    }

    @Test
    public void unionOneChainOfLeavesWithSingleLeafShouldReturnTheSortedLeavesWithThisLeafInIt() throws Exception {
        Leaf leaf1 = new Leaf(1, new Leaf(3, new Leaf(4)));
        Leaf leaf2 = new Leaf(3);
        Leaf union = LeafUtils.unionSorted(leaf1, leaf2);
        assertEquals("1 -> 3 -> 3 -> 4 -> null", union.toString());
    }

    @Test
    public void unionOfTwoChainOfSortedLeavesThatHaveDifferentValuesShouldReturnChainOfSortedLeaves() throws Exception {
        Leaf leaf1 = new Leaf(4, new Leaf(8, new Leaf(9)));
        Leaf leaf2 = new Leaf(21, new Leaf(30, new Leaf(33)));
        Leaf union = LeafUtils.unionSorted(leaf1, leaf2);
        assertEquals("4 -> 8 -> 9 -> 21 -> 30 -> 33 -> null", union.toString());
    }

    @Test
    public void sortOfSingleLeafShouldReturnThisLeaf() throws Exception {
        Leaf leaf = new Leaf(5);
        assertEquals("5 -> null", leaf.toString());
        Leaf sorted = LeafUtils.sort(leaf);
        assertEquals("5 -> null", sorted.toString());
    }

    @Test
    public void sortChainOfFourLeavesShouldReturnSortedChainOfLeaves() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(2))
                .addLeaf(new Leaf(4))
                .addLeaf(new Leaf(3))
                .addLeaf(new Leaf(1))
                .build();
        assertEquals("2 -> 4 -> 3 -> 1 -> null", leaf.toString());
        Leaf sorted = LeafUtils.sort(leaf);
        assertEquals("1 -> 2 -> 3 -> 4 -> null", sorted.toString());
    }

    @Test
    public void sortChainOfFiveLeavesShouldReturnSortedChainOfLeaves() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(2))
                .addLeaf(new Leaf(4))
                .addLeaf(new Leaf(3))
                .addLeaf(new Leaf(6))
                .addLeaf(new Leaf(1))
                .build();
        assertEquals("2 -> 4 -> 3 -> 6 -> 1 -> null", leaf.toString());
        Leaf sorted = LeafUtils.sort(leaf);
        assertEquals("1 -> 2 -> 3 -> 4 -> 6 -> null", sorted.toString());
    }

    @Test
    public void sortChainOfIdenticalLeavesShouldReturnTheSameChain() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(7))
                .addLeaf(new Leaf(7))
                .addLeaf(new Leaf(7))
                .addLeaf(new Leaf(7))
                .addLeaf(new Leaf(7))
                .build();
        assertEquals("7 -> 7 -> 7 -> 7 -> 7 -> null", leaf.toString());
        Leaf sorted = LeafUtils.sort(leaf);
        assertEquals("7 -> 7 -> 7 -> 7 -> 7 -> null", sorted.toString());
    }

    @Test
    public void partitionOfChainOfLeaveShouldReturnListWithTwoElements() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(1))
                .addLeaf(new Leaf(2))
                .addLeaf(new Leaf(3))
                .addLeaf(new Leaf(4))
                .build();
        List<Leaf> partition = LeafUtils.partition(leaf, 3);
        assertEquals("1 -> 2 -> null", partition.get(0).toString());
        assertEquals("3 -> 4 -> null", partition.get(1).toString());
    }

    @Test
    public void partitionOfChainOfLeaveShouldReturnListWithSecondElementIsNullIfSumLessThatMaxWeight() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(1))
                .addLeaf(new Leaf(2))
                .addLeaf(new Leaf(3))
                .addLeaf(new Leaf(4))
                .build();
        List<Leaf> partition = LeafUtils.partition(leaf, 10);
        assertEquals("1 -> 2 -> 3 -> 4 -> null", partition.get(0).toString());
        assertNull(partition.get(1));
    }

    @Test
    public void partitionOfChainOfLeaveShouldReturnListWithFirstElementIsNullIfWeightFirstElementMoreThatMaxWeight() throws Exception {
        Leaf leaf = Leaf.getChainBuilder()
                .addLeaf(new Leaf(5))
                .addLeaf(new Leaf(6))
                .addLeaf(new Leaf(7))
                .addLeaf(new Leaf(9))
                .build();
        List<Leaf> partition = LeafUtils.partition(leaf, 4);
        assertNull(partition.get(0));
        assertEquals("5 -> 6 -> 7 -> 9 -> null", partition.get(1).toString());
    }

}