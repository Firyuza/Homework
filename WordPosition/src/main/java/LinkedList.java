/**
 * Created by Фирюза on 16.05.14.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * private class for creating Node
     */
    private class Node {
        private int value;
        private Node next;

        public Node() {
            this.next = null;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public Node getNext() {
            return this.next;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getValue() {
            return this.value;
        }
    }
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * private method
     * to check for emptiness
     * @return
     */
    private boolean isEmpty() {
        return this.head == null;
    }

    /**
     * public method
     * to push the element
     * @param value
     */
    public void push(int value) {
        if (isEmpty()) {
            this.head = new Node();
            this.tail = this.head;
            this.head.setValue(value);
        }
        else  {
            this.tail.setNext(new Node());
            this.tail = this.tail.getNext();
            this.tail.setNext(null);
            this.tail.setValue(value);
        }
        this.size++;
    }
    /**
     * overloaded method for printing all elements that list contains
     */
    public String toString() {
        String sequence = "";
        Node current = this.head;
        if (current != null) {
            while (current != null) {
                sequence += current.getValue() + " ";
                current = current.getNext();
            }
        }
        else {
            sequence += "There is no such word!";
        }
        return sequence;
    }
}
