import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CopyArrBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr= new int[]{1, 2, 3};
    }

    @Test(timeout = 100)
    public void copyArr() {

        int[] copy = Program.copyArr(arr);

        assertNotEquals(arr, copy);   // not the same pointer
        assertArrayEquals(arr, copy); // same values

        assertArrayEquals(null, Program.copyArr(null));       // null test
        assertArrayEquals(new int[] {}, Program.copyArr(new int[] {})); // empty test
    }
}