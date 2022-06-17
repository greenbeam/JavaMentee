package MyLinkedList;

public class Node {
    private Object item;
    private Node next;

    public Node(){
    }

    public Node(Object item) {
        this(item, null);
    }

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }


    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
