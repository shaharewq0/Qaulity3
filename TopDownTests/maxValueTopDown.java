import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #10
    Test: maxValue,sumMinMax
    Stubs: minValueIndexTopDown,maxValueIndex
 */
@RunWith(Parameterized.class)
public class maxValueTopDown {
    private Program p;
    private TestType type;
    private int[] arr1;
    private int expectedOutput;

    enum TestType { //used to define parameters for each test
        sum, max
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {

                {TestType.max,new int[]{1, 2},2},
                {TestType.max,new int[]{0, 4, 3},4},
                {TestType.max,new int[]{1},1},

                {TestType.sum,new int[]{1, 2},3},
                {TestType.sum,new int[]{0, 4, 3},4},
                {TestType.sum,new int[]{1},2}
        });
    }

    public maxValueTopDown(TestType tp, int[] arr1, int expectedOutput) {
        this.p = new ProgramStub();
        type=tp;
        this.arr1 = arr1;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void maxValue() {
        if(type==TestType.max) {
            int max=p.maxValue(arr1);
            for(int i=0;i<arr1.length;i++) {
                assertTrue(arr1[i]<=max);
            }
            assertEquals(expectedOutput,max);
        }
    }

    @Test
    public void sumMinMax() {
        if(type==TestType.sum)
            assertEquals(expectedOutput, p.sumMinMax(arr1));
    }

    static class ProgramStub extends Program {
        // stub minValueIndexTopDown
        public int minValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            return 0;
        }
        //stub maxValueIndex
        public int maxValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            if(arr.length==1) return 0;
            return 1;
        }
    }
}