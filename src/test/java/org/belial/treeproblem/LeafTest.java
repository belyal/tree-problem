package org.belial.treeproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeafTest {

    @Test
    public void singleLeafShouldNotPointToAnything() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(1);
        assertNull(b1.getNext());
    }

    @Test
    public void oneLeafShouldPointToNextLeaf() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(1);
        Leaf<Integer> b3 = new Leaf<>(3, b1);
        assertEquals(b1, b3.getNext());
        assertNull(b1.getNext());
    }

    @Test
    public void leafShouldHaveGivenValue() throws Exception {
        Leaf<Integer> b4 = new Leaf<>(4);
        assertEquals(new Integer(4), b4.getValue());
    }

    @Test
    public void singleLeafShouldPrintItsValue() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(1);
        assertEquals("1 -> null", b1.toString());
    }

    @Test
    public void chainOfLeavesShouldPrintTheirValues() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(1);
        Leaf<Integer> b3 = new Leaf<>(3, b1);
        assertEquals("3 -> 1 -> null", b3.toString());
    }

    @Test
    public void leavesShouldBeComparable() throws Exception {
        Leaf<Integer> b5 = new Leaf<>(5);
        Leaf<Integer> b3 = new Leaf<>(3, b5);
        assertTrue(b5.compareTo(b3) > 0);
    }

    @Test
    public void oneLeafShouldEqualToOtherIfTheyHaveTheSameValue() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(13);
        Leaf<Integer> b2 = new Leaf<>(13);
        assertTrue(b1.compareTo(b2) == 0);
    }

    @Test
    public void leavesChainBuilderShouldCreateChainOfLeavesInOrderOfAddingLeaves() throws Exception {
        Leaf<Integer> leaf = Leaf.<Integer>getChainBuilder()
                .addLeaf(new Leaf<>(2))
                .addLeaf(new Leaf<>(4))
                .addLeaf(new Leaf<>(3))
                .addLeaf(new Leaf<>(1))
                .build();
        assertEquals("2 -> 4 -> 3 -> 1 -> null", leaf.toString());
    }

}