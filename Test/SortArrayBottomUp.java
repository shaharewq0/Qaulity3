import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortArrayBottomUp {
    int[] arr;
    int[] sorted;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,2,1};
        sorted=new int[]{1,2,3};
    }

    @Test
    public void sortArray() {
        assertTrue(Program.equalArrays(Program.sortArray(arr),sorted));
        assertFalse(Program.equalArrays(Program.sortArray(arr),arr));

        assertTrue(Program.equalArrays(Program.sortArray(null),null));
        assertTrue(Program.equalArrays(Program.sortArray(new int[]{}),new int[]{}));
    }
}