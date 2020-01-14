import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class minValueIndexBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{1,2,3};
    }

    @Test
    public void minValueIndex() {
        assertEquals(0,Program.minValueIndex(arr));
        for (int i=1;i<Program.size(arr);i++){
            assertNotEquals(i,Program.minValueIndex(arr));
        }
    }
}