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
        Leaf<Integer> b1 = new Leaf<>(1, null);
        assertEquals("1 -> null", b1.toString());
    }

    @Test
    public void chainOfLeavesShouldPrintTheirValues() throws Exception {
        Leaf<Integer> b1 = new Leaf<>(1, null);
        Leaf<Integer> b3 = new Leaf<>(3, b1);
        assertEquals("3 -> 1 -> null", b3.toString());
    }

}