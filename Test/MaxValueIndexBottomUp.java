import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxValueIndexBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,2,1};
    }

    @Test(timeout = 100)
    public void maxValueIndex() {
        assertEquals(0,Program.maxValueIndex(arr));

        assertEquals(-1,Program.maxValueIndex(null));
        //assertEquals(-1,Program.maxValueIndex(new int[] {}));

        //TODO : empty?
    }
}