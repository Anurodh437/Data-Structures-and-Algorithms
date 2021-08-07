package datastructure.linear.lists.doubly.node;

public class Node<E> {

    /* The data value */
    private final E data;

    /* The link to the next node */
    private Node<E> next;

    /* The link to the previous node */
    private Node<E> previous;

    /** Construct a node with the given data value.
     @param dataItem The data value
     */
    private Node(E dataItem){
        this.data = dataItem;
        this.next = null;
        this.previous = null;
    }

    /**
     * This constructor is used in the case that we want to create a node, and we have both the data of the node and
     * the
     * */
    public Node(E data, Node<E> previous, Node<E> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    /**
     * This is the public getter method for reading the value of the data of a node.
     *
     * @return returns the actual data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     * This is the public getter method for reading the reference value of the next node of the current node.
     *
     * @return returns the reference of the next node.
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * This is the public getter method for reading the reference value of the previous node of the current node.
     *
     * @return returns the reference of the previous node.
     */
    public Node<E> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
