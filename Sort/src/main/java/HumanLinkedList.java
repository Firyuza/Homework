/**
 * Created by Фирюза on 19.04.14.
 */
public class HumanLinkedList {

    private class Node {
        private Human human;
        private Node next;
        public Node(Human human) {
            this.setHuman(human);
            this.setNext(null);
        }

        public Human getHuman() {
            return human;
        }

        public void setHuman(Human human) {
            this.human = human;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node current;
    private Node tail;

    public HumanLinkedList() {
        this.head =null;
        this.current = null;
        this.tail = null;
    }
    public boolean endOfList() {
        return this.current == this.tail;
    }
    public boolean isEmpty() {
        return this.tail == null;
    }
    //was changed by lexicological sorting
    public void add(Human human) {
        Node node = new Node(human);
        if (isEmpty()) {
            this.head = node;
            this.tail = node;
            this.tail.setNext(null);
        }
        else {
            Node q = this.head;
            boolean find = false;
            if (q.getHuman().getName().compareTo(node.getHuman().getName()) > 0) {
                node.setNext(this.head);
                this.head = node;
                find = true;
            }
            while (q.getNext() != null && !find) {
                if (q.getNext().getHuman().getName().compareTo(node.getHuman().getName()) < 0) {
                    q = q.getNext();
                }
                else {
                    node.setNext(q.getNext());
                    q.setNext(node);
                    find = true;
                }
            }
            if (!find) {
                this.tail.setNext(node);
                this.tail = node;
                this.tail.setNext(null);
            }
        }
        this.current = this.head;
    }
    public Human getCurrent() {
       if (this.current != null) {
          Human result =  this.current.getHuman();
          this.current = this.current.getNext();
          return result;
       }
        else {
           // TODO: make exception
           return null;
       }
    }
    public void append(HumanLinkedList list) {
        if (!list.isEmpty()) {
            if(!(this.isEmpty())) {
                this.tail.setNext(list.head);
                this.tail = list.tail;
            }
            else {
                this.head = list.head;
                this.tail = list.tail;
            }
        }
    }
}
