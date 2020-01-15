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

        int min = Program.minValueIndex(arr);
        int max = Program.maxValueIndex(arr);

        int min_s = Program.minValueIndex(swaped);
        int max_s = Program.maxValueIndex(swaped);

        assertEquals(min,max_s);
        assertEquals(max,min_s);

        assertEquals(arr.length,swaped.length); // same length

        for (int i =0; i< arr.length; i++ ){
            if(i != min && i != max) { // should stay the same
                assertEquals(arr[i], swaped[i]);
            }
        }


        //TODO : null?
        //TODO : empty?
    }
}