import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class sizeBottomUp {
    public int[] arr;
    @Before
    public void setUp() throws Exception {
        arr= new int[]{1, 2, 3};
    }

    @Test(timeout = 100)
    public void size() {
        assertEquals(3,Program.size(arr));
        assertNotEquals(0,Program.size(arr));
    }
}