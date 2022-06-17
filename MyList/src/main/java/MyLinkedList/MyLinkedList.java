package MyLinkedList;

import MyLinkedList.Node;

public class MyLinkedList {

    private static Node listHead;
    private static int listCount;

    public static void main(String[] args) {
        listHead = new Node(null);
        listCount = 0;

        add("1");
        add("3");
        add("8");
        System.out.println(size());
        remove(2);
        System.out.println(listToString());
    }

    public static void add(Object item) {
        Node currentNode = listHead;
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        Node tempNode = new Node(item);
        currentNode.setNext(tempNode);
        listCount++;
    }

    public static boolean remove(int index) {
        if (index < 1 || index > size()) {
            return false;
        }

        Node currentNode = listHead;
        for (int i = 1; i < index; i++) {
            if (currentNode.getNext() == null) {
                return false;
            }
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());

        listCount--;
        return true;
    }

    public static String listToString() {
        Node currentNode = listHead.getNext();
        StringBuilder builder = new StringBuilder();
        while (currentNode != null) {
            builder.append("[" + currentNode.getItem().toString() + "]");
            currentNode = currentNode.getNext();
        }
        return builder.toString();
    }

    public static int size() {
        return listCount;
    }

}
