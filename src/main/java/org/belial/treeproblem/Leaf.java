package org.belial.treeproblem;

/**
 * The Leaf represents the content of a node.
 * <p>It has a pointer to the next leaf (pointer can be {@code null} if it is a terminal leaf).</p>
 *
 * @param <T> the type of value in this leaf
 */
public class Leaf<T extends Comparable<T>> implements Comparable<Leaf<T>> {
    private final T value;
    private Leaf<T> next;

    public Leaf(T value) {
        this(value, null);
    }

    public Leaf(T value, Leaf<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Leaf<T> getNext() {
        return next;
    }

    public void setNext(Leaf<T> next) {
        this.next = next;
    }

    @Override
    public int compareTo(Leaf<T> other) {
        return getValue().compareTo(other.getValue());
    }

    @Override
    public String toString() {
        return value + " -> " + next;
    }
}
