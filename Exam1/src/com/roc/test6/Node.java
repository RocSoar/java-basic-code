package com.roc.test6;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setNext(Node<T> e) {
        next = e;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
