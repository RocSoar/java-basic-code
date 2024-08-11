package com.roc.test6;

public class Test {
    public static void main(String[] args) {
        // 第一个链表：
        MyLinkedList<Integer> list1 = new MyLinkedList<>();
        list1.add(2);
        list1.add(4);
        list1.add(1);
//        list1.add(5);
//        list1.add(3);
//        list1.add(6);
        // 第一个链表的头结点：head1
        MyLinkedList.Node<Integer> head1 = list1.head;

        // 第二个链表：
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(4);
        list2.add(1);
        list2.add(3);
//        list2.add(8);
//        list2.add(7);

        // 第二个链表的头结点：head1
        MyLinkedList.Node<Integer> head2 = list2.head;

        // 功能1：在MyLinkedList类中，开发一个sort方法，对两个链表分别排序，并分别遍历输出

        // 功能2：在MyLinkedList类中，开发一个mergeSort方法，支持将这两个升序排序的链表，合并成一个新链表，要求新链表中的节点仍然是递增排序的。
        // ，然后对新链表遍历输出

//        此为希尔排序算法实现的排序, 之所以没用快速排序是因为学艺还不精, 当然希尔排序本身也很快了
        list1.sort((a, b) -> a - b);
        list2.sort((a, b) -> a - b);

        System.out.println(list1);
        System.out.println("size: " + list1.size());
        System.out.println("====================================");
        System.out.println(list2);
        System.out.println("size: " + list2.size());

//      此为完全的归并排序算法实现, 要合并排序的两个链表可以不必为已经排好序的
        MyLinkedList<Integer> sorted = list1.mergeAndSorted(list2, (a, b) -> a - b);

        System.out.println("====================================");
        System.out.println(sorted);
        System.out.println("size: " + sorted.size());
    }
}
