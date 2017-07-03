package org.belial.treeproblem;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeNodeTest {

    @Test
    public void treeNodeShouldContainGivenLeavesAndChildNodes() throws Exception {
        Leaf<Integer> leaf = Leaf.<Integer>getChainBuilder()
                .addLeaf(new Leaf<>(2))
                .addLeaf(new Leaf<>(4))
                .addLeaf(new Leaf<>(3))
                .addLeaf(new Leaf<>(1))
                .build();
        TreeNode<Integer> treeNode = new TreeNode<>("root");
        treeNode.setLeaves(leaf);
        treeNode.addChild(new TreeNode<>("a1"));
        treeNode.addChild(new TreeNode<>("a2"));
        treeNode.addChild(new TreeNode<>("a3"));

        assertEquals("2 -> 4 -> 3 -> 1 -> null", treeNode.getLeaves().toString());
        assertEquals(3, treeNode.getChildren().size());
        assertNotNull(treeNode.getChildByName("a1"));
        assertNotNull(treeNode.getChildByName("a2"));
        assertNotNull(treeNode.getChildByName("a3"));
    }

}