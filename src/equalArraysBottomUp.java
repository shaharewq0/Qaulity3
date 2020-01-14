import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class equalArraysBottomUp {
    int[] arr1;
    int[] arr2;
    int[] arr3;
    int[] arr4;
    @Before
    public void setUp() throws Exception {
        arr1=new int[]{3,2,1};
        arr2=new int[]{3,2,1};
        arr3=new int[]{2,3,1};
        arr4=new int[]{};
    }


    @Test(timeout = 100)
    public void equalArrays() {
        assertTrue(Program.equalArrays(arr1,arr2));//equal
        assertFalse(Program.equalArrays(arr1,arr3));//diff order
        assertFalse(Program.equalArrays(arr1,arr4));// dif size
    }
}