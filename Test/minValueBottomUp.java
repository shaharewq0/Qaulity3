import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class minValueBottomUp {
    int[] arr;
    @Before
    public void setUp() throws Exception {
        arr=new int[]{3,2,1};
    }

    @Test
    public void minValue() {

        assertEquals(arr[2],Program.minValue(arr));


        //TODO :  null?
        //TODO :  empty?
    }
}