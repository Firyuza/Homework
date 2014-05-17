import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Фирюза on 17.05.14.
 */
public class LinkedListTest {
    public LinkedList list;
    @Before
    public void setUp() throws Exception {
        this.list = new LinkedList();
    }

    @Test
    public void testToString() throws Exception {
        this.list.push(3);
        this.list.push(4);
        Assert.assertEquals(this.list.toString(),"3 4 ");
    }
}
