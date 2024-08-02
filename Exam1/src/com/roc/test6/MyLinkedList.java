package com.roc.test6;

import java.util.LinkedList;
import java.util.Objects;
import java.util.StringJoiner;

public class MyLinkedList<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
    }

    public Node<T> add(T e) {
        Node<T> newNode = new Node<>(e, null);
        Node<T> l = last;
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.setNext(newNode);
        size++;
        return first;
    }

    public Node<T> reverse(int left, int right) {
        Objects.requireNonNull(first);
        if (left < 1 || right > size || left > right)
            throw new IndexOutOfBoundsException("left " + left + " or right " + right + " out of bounds");

        if (left == right)
            return first;

        Node<T>[] nodes = new Node[right - left + 1];
        Node<T> start = null;
        Node<T> end = null;
        int count = 1;
        int index = 0;
        Node<T> current = first;
        while (true) {
            if (count > right) {
                end = current;
                break;
            }
            if (count == left - 1) {
                start = current;
            }
            if (count >= left) {
                nodes[index++] = current;
            }
            current = current.getNext();
            count++;
        }

        for (int i = nodes.length - 1; i >= 0; i--) {
            if (i == nodes.length - 1) {
                if (start == null) {
                    first = nodes[i];
                    first.setNext(nodes[i - 1]);
                } else {
                    start.setNext(nodes[i]);
                    nodes[i].setNext(nodes[i - 1]);
                }
            } else if (i == 0) {
                nodes[i].setNext(end);
                if (end == null)
                    last = nodes[i];
            } else {
                nodes[i].setNext(nodes[i - 1]);
            }
        }
        return first;
    }

    public int length() {
        return size;
    }

    public void forEach(Consumer<T> action) {
        for (Node<T> current = first; current != null; current = current.getNext())
            action.accept(current.getData());
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Node<T> current = first; current != null; current = current.getNext())
            sj.add(current.getData().toString());
        return sj.toString();
    }
}

@FunctionalInterface
interface Consumer<K> {
    void accept(K e);
}
