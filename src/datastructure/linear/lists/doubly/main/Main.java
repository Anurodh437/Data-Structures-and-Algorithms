package datastructure.linear.lists.doubly.main;

import datastructure.linear.lists.doubly.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(0, 45);
        doublyLinkedList.add(23);
        doublyLinkedList.add(23);
        doublyLinkedList.remove();
        System.out.println(doublyLinkedList);
    }
}
