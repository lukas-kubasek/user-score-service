package cz.kubasek.userscore.model;

import java.util.Objects;

public class Node {

    public static final Node EMPTY_NODE = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);

    private int level;

    private int value;
    private long count;

    private Node left;
    private Node right;

    public Node(int level, int value) {
        this.level = level;
        this.value = value;
        this.count = 1;
    }

    public int getLevel() {
        return level;
    }

    public int getValue() {
        return value;
    }

    public long getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return !this.equals(EMPTY_NODE) ? String.format("%d:%d", value, count) : "";
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return value == ((Node) o).value;
    }
}
