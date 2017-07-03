package org.belial.treeproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * The TreeNode represents the node of tree.
 * <p>Each node can have any numbers of leaves {@link Leaf}</p>
 * @param <T> the type of value in a leaf of the node
 */
public class TreeNode<T extends Comparable<T>> {
    private final String name;
    private Leaf<T> leaves;
    private List<TreeNode<T>> children;

    public TreeNode(String name) {
        this.name = name;
    }

    public void setLeaves(Leaf<T> data) {
        this.leaves = data;
    }

    public Leaf<T> getLeaves() {
        return leaves;
    }

    public void addChild(TreeNode<T> child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(child);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public TreeNode<T> getChildByName(String name) {
        return children.stream()
                .filter(treeNode -> name.equals(treeNode.name))
                .findFirst()
                .orElse(null);
    }

}
