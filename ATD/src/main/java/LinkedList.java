/**
 * Created by Фирюза on 30.03.14.
 */
public class LinkedList<Item> implements List<Item> {

    private Node top;

    public class Node {
        Item value;
        Node next;
    }

    public LinkedList(){
        this.top = null;
    }

    public Node getTop() {
        return this.top;
    }
    private Node getLast() {
        Node q = null;
        Node p = this.top;
        while (p != null) {
            q = p;
            p = p.next;
        }
        return q;
    }

    @Override
    public void add(Item value) {
        if (this.top == null) {
            this.top = new Node();
            this.top.next = null;
            this.top.value = value;
        }
        else {
            Node q = getLast();
            if (q == null) {
                this.top = new Node();
                this.top.next = null;
                this.top.value = value;
            }
            else {
                Node last = new Node();
                q.next = last;
                last.next = null;
                last.value = value;
            }
        }
    }
    @Override
    public Item remove() {
        Item value = null;
        try {
            if (top.next == null) {
                value = this.top.value;
                top = null;
            } else {
                Node q = null;
                Node p = this.top;
                while (p.next != null) {
                    q = p;
                    p = p.next;
                }
                value = q.next.value;
                q.next = null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return value;
    }

    @Override
    public Item peek() {
        Node q = getLast();
        return q.value;
    }
}
