import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class copyArrBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr= new int[]{1, 2, 3};
    }

    @Test(timeout = 100)
    public void copyArr() {
        assertNotEquals(arr,Program.copyArr(arr));
        for(int i=0;i<Program.size(arr);i++){
            assertEquals(arr[i],Program.copyArr(arr)[i]);
        }
    }
}