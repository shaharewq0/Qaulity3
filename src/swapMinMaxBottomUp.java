import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class swapMinMaxBottomUp {
    int[] arr;
    int[] swaped;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,2,1};
        swaped=Program.swapMinMax(arr);

    }


    @Test
    public void swapMinMax() {
        assertEquals(swaped[Program.minValueIndex(arr)],arr[Program.maxValueIndex(arr)]);
        assertEquals(swaped[Program.maxValueIndex(swaped)],arr[Program.minValueIndex(swaped)]);
    }
}