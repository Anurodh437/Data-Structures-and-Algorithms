package datastructure.linear.lists.doubly;

import abstractdatatype.AbstractDataType;
import datastructure.linear.lists.doubly.node.Node;

public class DoublyLinkedList<E> implements AbstractDataType<E> {
    /*
     * This field will store the reference to the first node in the linked list.
     * */
    private Node<E> head = null;

    /*
     * This field will store the reference to the last node in the linked list.
     * */
    private Node<E> tail = null;

    /*
     * This field will store the current size of the linked list.
     * */
    private int size = 0;

    @Override
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    /**
     * This method will add an item node in the linked list at the given item.
     *
     * @param index The index of the linked list at which the node is to be added.
     * @param item  The data value of the node to be created and added to the linked list.
     * @throws IndexOutOfBoundsException If the index is negative or greater than the size.
     */
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            // throw the IndexOutOfBoundsException if the index given is incorrect.
            throw new IndexOutOfBoundsException(index);
        } else if (index == 0) {
            // the node is to be added at the first index, call the addFirst() method
            addFirst(item);
        } else {
            // the node is to be added somewhere after a given node
            // firstly, get the node after which we have to add a new node.
            Node<E> previousNode = getNode(index - 1);
            // call the addAfter() method to add the node after 'previousNode'.
            addAfter(previousNode, item);
        }
    }

    private void addFirst(E item) {
        head = new Node<>(item, null, null);
        tail = head;
        size++;
    }

    private void addAfter(Node<E> previousNode, E item) {
        Node<E> nextNode = previousNode.getNext();
        Node<E> newNode = new Node<>(item, previousNode, nextNode);
        previousNode.setNext(newNode);
        if (nextNode != null) {
            nextNode.setPrevious(newNode);
        } else {
            tail = newNode;
        }
        size++;
    }

    @Override
    public E remove() {
        // remove the last element from the linked list
        return remove(size - 1);
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            // we are trying to delete the first element (head node) in the linked list
            return removeFirst();
        } else {
            Node<E> previousNode = getNode(index - 1);
            return removeAfter(previousNode);
        }
    }

    private E removeAfter(Node<E> previousNode) {
        E removedValue = null;
        Node<E> nodeToBeDeleted = previousNode.getNext();
        if (nodeToBeDeleted != null) {
            removedValue = nodeToBeDeleted.getData();
            previousNode.setNext(nodeToBeDeleted.getNext());
            size--;
        }
        return removedValue;
    }

    private E removeFirst() {
        E removedData = null;
        if (head != null) {
            removedData = head.getData();
            head = head.getNext();
            size--;
        }
        return removedData;
    }

    /**
     * This method will return a node at the specified index from the linked list.
     *
     * @param index A non-negative index from the linked list.
     * @return The node at the specified index.
     */
    public Node<E> getNode(int index) {
        Node<E> currentNode = head;
        /*
         * using a loop to traverse the whole linked list,
         * the loop will run until i is less than the size of the linked list,
         * AND
         * the current node traversed is not equal to null.
         * */
        for (int i = 0; i < index; i++) {
            // change the reference value of the response variable to the next node
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder();
        Node<E> currentNode = head;
        listString.append("[");
        for (int i = 0; i < size; i++) {
            if (currentNode != null) {
                listString.append(currentNode.getData());
                currentNode = currentNode.getNext();
            }
            if (i < size - 1) {
                listString.append(", ");
            }
        }
        listString.append("]");
        return listString.toString();
    }
}
