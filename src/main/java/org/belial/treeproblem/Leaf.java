package org.belial.treeproblem;

/**
 * The Leaf represents the content of a node.
 * <p>It has a pointer to the next leaf (pointer can be {@code null} if it is a terminal leaf).</p>
 */
public class Leaf implements Comparable<Leaf> {
    private final int weight;
    private Leaf next;

    public Leaf(int weight) {
        this(weight, null);
    }

    public Leaf(int weight, Leaf next) {
        this.weight = weight;
        this.next = next;
    }

    public int getWeight() {
        return weight;
    }

    public Leaf getNext() {
        return next;
    }

    public void setNext(Leaf next) {
        this.next = next;
    }

    @Override
    public int compareTo(Leaf other) {
        return Integer.compare(weight, other.getWeight());
    }

    @Override
    public String toString() {
        return weight + " -> " + next;
    }

    public static ChainBuilder getChainBuilder() {
        return new ChainBuilder();
    }

    /**
     * Builder class that simplifies the creation of chain of leaves.
     */
    static class ChainBuilder {
        private Leaf first;
        private Leaf last;

        public ChainBuilder addLeaf(Leaf leaf) {
            if (last == null) {
                first = last = leaf;
            } else {
                last.setNext(leaf);
                last = leaf;
            }
            return this;
        }

        public Leaf build() {
            return first;
        }
    }
}
