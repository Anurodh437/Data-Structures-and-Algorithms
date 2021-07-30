import datastructure.linked.LinkedListClass;

public class Main {
    public static void main(String[] args) {
        LinkedListClass<Integer> linkedList = new LinkedListClass<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.remove(linkedList.size()-1);
        System.out.println(linkedList);
    }
}
