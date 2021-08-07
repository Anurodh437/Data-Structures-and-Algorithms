package datastructure.linear.lists.singly.node;

/*This Node class is generated or created as generic so that it is possible to create classes that work with different data types.
reference type(pre-defined or user-defined) in java.
*/

public class Node<E> {

  //E type data specifies that the data variable can be of any reference type.
   private final E data;

   //this variable will have node of type E which will store link to the next.
   public Node<E> next;

   //Constructor to use in case when we want to create a new node, and we have data only.
   public Node(E data){
     this.data = data;
     this.next = null;
   }

  //Constructor to use in case when we want to create a new node, and we have data only.
  public Node(E data, Node<E> next){
     this.data = data;
     this.next = next;
   }

   //This is a public getter method for reading the value of the data of a node.
   public E getData(){
     return data;
   }

   //This is the public getter method for reading the reference value of the next node of current node.
    public Node<E> getNext(){
     return next;
    }

    //This method is used to set the next reference value.
    public void setNext(Node<E> next){
     this.next = next;
    }
}