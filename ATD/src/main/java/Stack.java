/**
 * Created by Фирюза on 30.03.14.
 */
public class Stack<Item> {

    private LinkedList<Item> list;

    public Stack() {
        list = new LinkedList<Item>();
    }
    public Stack(Item value) {
        this();
        list.add(value);
    }
    public Stack(Stack stack) {
        this();
        LinkedList.Node q = stack.list.getTop();
        while(q != null) {
            this.list.add((Item)q.value);
            q = q.next;
        }
    }
    public void push(Item value) {
        this.list.add(value);
    }
    public Item pop() {
        return this.list.remove();
    }
    public Item peek() {
        return this.list.peek();
    }
    public int size() {
        int N  = 0;
        LinkedList.Node q = this.list.getTop();
        while (q != null) {
            N++;
            q = q.next;
        }
        return N;
    }
}
