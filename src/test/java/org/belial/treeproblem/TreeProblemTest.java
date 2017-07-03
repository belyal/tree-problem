package org.belial.treeproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeProblemTest {

    @Test
    public void treeNodeShouldHaveLeavesTheSumOfWhichIsNotGreaterThatGivenValue() throws Exception {
        Leaf leaf = Leaf.<Integer>getChainBuilder()
                .addLeaf(new Leaf(2))
                .addLeaf(new Leaf(4))
                .addLeaf(new Leaf(3))
                .addLeaf(new Leaf(1))
                .build();
        TreeNode treeNode = new TreeNode("root");
        treeNode.setLeaves(leaf);
        treeNode.addChild(new TreeNode("a1"));
        treeNode.addChild(new TreeNode("a2"));
        treeNode.addChild(new TreeNode("a3"));

        assertEquals("2 -> 4 -> 3 -> 1 -> null", treeNode.getLeaves().toString());
        assertNull(treeNode.getChildByName("a1").getLeaves());
        assertNull(treeNode.getChildByName("a2").getLeaves());
        assertNull(treeNode.getChildByName("a3").getLeaves());

        TreeProblem problem = new TreeProblem();
        problem.solve(treeNode, 3);

        assertEquals("1 -> 2 -> null", treeNode.getLeaves().toString());
        assertEquals("3 -> null", treeNode.getChildByName("a1").getLeaves().toString());
        assertNull(treeNode.getChildByName("a2").getLeaves());
        assertNull(treeNode.getChildByName("a3").getLeaves());
    }

}