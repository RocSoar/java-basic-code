package com.roc.test6;

import java.util.Comparator;
import java.util.StringJoiner;

public class MyLinkedList<E> {
    // 封装一个链表
    Node<E> head = null;
    Comparator<E> comparator;

    /**
     * 定义了一个私有的内部类，作为链表的结点。
     */
    public static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }

    public Node<E> add(E e) {
        if (head == null) {
            head = new Node<>(e, null);
        } else {
            // 往后面插入结点。（尾插法）
            Node<E> temp = head;
            // 让temp走到尾部结点
            while (temp.next != null) {
                temp = temp.next;
            }
            // 把当前结点创建出来，加入到尾部结点
            temp.next = new Node<>(e, null);
        }
        return head;
    }

    public int size() {
        int size = 0;
        Node<E> temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public void forEach(Consumer<E> action) {
        Node<E> temp = head;
        while (temp != null) {
            action.accept(temp.getData());
            temp = temp.next;
        }
    }

    public void sort(Comparator<E> comparator) {
        if (head == null) {
            return;
        }
        this.comparator = comparator;

        E[] arr = toDataArray();
        shellSort(arr);

        Node<E> temp = head;
        for (E e : arr) {
            temp.setData(e);
            temp = temp.next;
        }
    }

    private void shellSort(E[] arr) {
//       希尔排序 也是加入步长的插入排序
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                int index = i;
                E temp = arr[i];
                for (; index > 0; index -= step) {
                    if (index - step < 0 || comparator.compare(temp, arr[index - step]) >= 0)
                        break;
                    arr[index] = arr[index - step];
                }
                arr[index] = temp;
            }
        }
    }

    public MyLinkedList<E> mergeAndSorted(MyLinkedList<E> linkedList, Comparator<E> comparator) {
        if (head == null && linkedList.head == null)
            return null;

        this.comparator = comparator;
        E[] left = toDataArray();
        E[] right = linkedList.toDataArray();

        Object[] arr = mergeSort(split(left), split(right));

        MyLinkedList<E> res = new MyLinkedList<>();
        for (Object o : arr) {
            res.add((E) o);
        }
        return res;
    }

    private Object[] split(Object[] arr) {
        if (arr.length <= 1)
            return arr;

        int mid = arr.length / 2;
        Object[] left = new Object[mid];
        Object[] right = new Object[arr.length - mid];

        for (int i = 0; i < arr.length; i++) {
            if (i < mid)
                left[i] = arr[i];
            else
                right[i - mid] = arr[i];
        }
        return mergeSort(split(left), split(right));
    }

    private Object[] mergeSort(Object[] left, Object[] right) {
//        归并排序
        Object[] arr = new Object[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (leftIndex >= left.length)
                arr[i] = right[rightIndex++];
            else if (rightIndex >= right.length)
                arr[i] = left[leftIndex++];
            else if (comparator.compare((E) left[leftIndex], (E) right[rightIndex]) < 0)
                arr[i] = left[leftIndex++];
            else
                arr[i] = right[rightIndex++];
        }

        return arr;
    }

    public E[] toDataArray() {
        Object[] arr = new Object[size()];
        Node<E> temp = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.getData();
            temp = temp.next;
        }
        return (E[]) arr;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        forEach(e -> sj.add(e.toString()));
        return sj.toString();
    }

    @FunctionalInterface
    interface Consumer<T> {
        void accept(T t);
    }
}