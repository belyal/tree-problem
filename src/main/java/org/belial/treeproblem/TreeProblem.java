package org.belial.treeproblem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeProblem {

    public void solve(TreeNode treeNode, int w) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        Leaf remainingLeaves = null;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            Leaf sortedLeaves = LeafUtils.sort(node.getLeaves());
            Leaf unionSorted = LeafUtils.unionSorted(sortedLeaves, remainingLeaves);

            List<Leaf> partition = LeafUtils.partition(unionSorted, w);
            node.setLeaves(partition.get(0));
            remainingLeaves = partition.get(1);

            List<TreeNode> children = node.getChildren();
            if (children != null) {
                queue.addAll(node.getChildren());
            }
        }
    }

}
