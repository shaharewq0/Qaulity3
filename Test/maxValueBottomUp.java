import org.junit.Test;

import static org.junit.Assert.*;


public class maxValueBottomUp {

    @Test(timeout = 100)
    public void maxValue() {

        assertEquals(6, Program.maxValue(new int[]{3, 5, 4, 1, 6, 2}));
        assertEquals(3, Program.maxValue(new int[]{3}));


        //TODO :  null?
        //TODO :  empty?
    }
}
