import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinValueIndexBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{1,2,3};
    }

    @Test
    public void minValueIndex() {
        assertEquals(0,Program.minValueIndex(arr));

        assertEquals(-1,Program.minValueIndex(null));

        //assertEquals(-1,Program.minValueIndex(new int[] {}));

        //TODO : empty?
    }
}