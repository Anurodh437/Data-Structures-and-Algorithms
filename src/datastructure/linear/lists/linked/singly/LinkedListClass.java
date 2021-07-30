package datastructure.linear.lists.linked.singly;

import abstractdatatype.AbstractDataType;
import datastructure.linear.lists.linked.singly.node.Node;


public class LinkedListClass<E> implements AbstractDataType<E> {
    /* This head reference variable will store the reference value for the first node object in the datastructure.linked list
    And has to be kept track in case if changed.
     */
    private Node<E> head = null;

    /*
    This size variable will keep the count of the total number of nodes in the datastructure.linked list except the head node.
     */
    private int size;

    @Override
    public boolean add(E item) {
        add(size,item);
        return true;
    }
    /**
     * This method will add an item node in the datastructure.linked list at the given item.
     *
     * @param index The index of the datastructure.linked list at which the node is to be added.
     * @param item  The data value of the node to be created and added to the datastructure.linked list.
     * @throws IndexOutOfBoundsException If the index is negative or greater than the size.
     */
    public void add(int index, E item){
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }else if(index == 0){
            addFirst(item);
        }else{
            Node<E> previousNode = getNode(index - 1);
            addAfter(previousNode,item);
        }
    }
    /*
    This method will add an item node to the beginning of the datastructure.linked list.
     */
    private void addFirst(E data){
        head = new Node<>(data,head);
        size++;
        /* or
        Node<E> node = new Node<E>(data);
         node.next = head;
         head = node;
        */
    }
    /**
     * This method will add an item node after a given node in the datastructure.linked list.
     * Similar to the addFirst() method, this method also receives only the data value, so we
     * would have create a node and then send it to the datastructure.linked list to be added after the
     * given node.
     *
     * @param node The node after which the new node is to be added.
     * @param item The data value of the node to be created and added to the datastructure.linked list.
     */
    private void addAfter(Node<E> node, E item){
        /*
         * The code following these comments is the summation of the two lines of code
         * written inside the comments.
         * Node<E> n1 = new Node<E>(item, node.next);
         * node.setNext(n1);
         */
        node.setNext(new Node<>(item,node.getNext()));
        size++;
    }


    @Override
    public E remove() {
        // if the index for removal of a node is not specified, just remove the first node in the datastructure.linked list
        // the operation will always be O(1).
        return remove(0);
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<E> previousNode = getNode(index - 1);
            return removeAfter(previousNode);
        }
    }
    /**
     * This method will remove the first node from the datastructure.linked list.
     *
     * @return The removed node's data or null if the list was empty.
     */
    private E removeFirst() {
        E removedValue = null;
        if (head != null) {
            removedValue = head.getData();
            head = head.getNext();
            size--;
        }
        return removedValue;
    }

    /**
     * This method will remove a node after the given node in the datastructure.linked list.
     *
     * @param previousNode The node after which the node is to be deleted.
     * @return the node's data that was deleted or null if there was no node.
     */
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
    /**
     * This method will return a node at the specified index from the datastructure.linked list.
     *
     * @param index An non-negative index from the datastructure.linked list.
     * @return The node at the specified index.
     */
    private Node<E> getNode(int index) {
        Node<E> currentNode = head;
        /*
         * using a loop to traverse the whole datastructure.linked list,
         * the loop will run until i is less than the size of the datastructure.linked list,
         * AND
         * the current node traversed is not equal to null.
         * */
        for (int i = 0; i < index; i++) {
            // change the reference value of the response variable to the next node
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
    // This method is used to get size of the datastructure.linked list.
    public int size(){
        return size;
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