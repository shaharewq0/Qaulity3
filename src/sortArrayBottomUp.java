import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class sortArrayBottomUp {
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

        //or if the use of Program.equalArrays is not good

        for (int i=0;i<Program.size(arr);i++){
            assertEquals(sorted[i],Program.sortArray(arr)[i]);
        }

        boolean equal=true;
        for (int i=0;i<Program.size(arr);i++){
            equal =equal && arr[i]==Program.sortArray(arr)[i];
        }
        assertFalse(equal);
    }
}