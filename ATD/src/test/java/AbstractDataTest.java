/**
 * Created by Фирюза on 05.04.14.
 */
import junit.framework.Assert;
import org.junit.Before;

public class AbstractDataTest {
    private LinkedList list;
    private Stack stack;

    @Before
    public void setUp() {
        this.list = new LinkedList<Integer>();
        this.stack = new Stack<Integer>();
    }
    @org.junit.Test
    public void testLinkedListAndStack() throws Exception {
        list.add(4);
        list.add(5);
        Integer res1 = (Integer)list.peek();
        Integer res2 = (Integer)list.remove();
        Integer res3 = (Integer)list.peek();
        Assert.assertEquals((int)res1, 5);
        Assert.assertEquals((int)res2, 5);
        Assert.assertEquals((int)res3, 4);

        stack.push(5);
        stack.push(9);
        stack.push(8);
        int size = stack.size();
        Integer re1 = (Integer) stack.peek();
        Integer re2 = (Integer) stack.pop();
        Integer re3 = (Integer) stack.pop();
        int size2 = stack.size();
        Assert.assertEquals(size,3);
        Assert.assertEquals((int)re1,8);
        Assert.assertEquals((int)re2, 8);
        Assert.assertEquals((int)re3, 9);
        Assert.assertEquals(size2, 1);
    }
}
