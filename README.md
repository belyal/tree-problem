Tree Problem
============

You are given a tree of arbitrary depth. Nodes of the tree have leaves (0 - N). Each leaf has some weight that is an integer non-zero number. The leaves for each node are represented as a unidirectional linked list.

For each node, sort the leaves by weight without using library function. At this, keep in mind, that the sum of the weights of the leaves for each particular node should not exceed the given constant W. The extra leaves are transferred to the next node of the tree. The extra leaves of the last node are discarded.

Example
-------
The tree node has 3 child nodes (a1, a2, a3) and 4 leaves (b1, b2, b3, b4), with the corresponding weights 1, 2, 3, and 4. The constant W = 3.

The initial state of the list of leaves for this node: b2, b4, b3, b1.

The final state of the leaf list for this node should be: b1, b2, with leaves b3, b4 being transferred to the child node a1.

Additional Requirements
-----------------------
* Project on BitBucket or GitHub
* Demonstration of using GitFlow workflow
* Code is covered by tests.
