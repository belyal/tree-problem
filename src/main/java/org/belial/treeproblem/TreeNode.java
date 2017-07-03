package org.belial.treeproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * The TreeNode represents the node of tree.
 * <p>Each node can have any numbers of leaves {@link Leaf}</p>
 */
public class TreeNode {
    private final String name;
    private Leaf leaves;
    private List<TreeNode> children;

    public TreeNode(String name) {
        this.name = name;
    }

    public void setLeaves(Leaf leaves) {
        this.leaves = leaves;
    }

    public Leaf getLeaves() {
        return leaves;
    }

    public void addChild(TreeNode child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public TreeNode getChildByName(String name) {
        return children.stream()
                .filter(treeNode -> name.equals(treeNode.name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "TreeNode<" + name + ", " + leaves + ", " + children + ">";
    }
}
