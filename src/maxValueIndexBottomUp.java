import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class maxValueIndexBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,2,1};
    }

    @Test(timeout = 100)
    public void maxValueIndex() {
        assertEquals(0,Program.maxValueIndex(arr));
        for (int i=1;i<Program.size(arr);i++){
            assertNotEquals(i,Program.maxValueIndex(arr));
        }
    }
}