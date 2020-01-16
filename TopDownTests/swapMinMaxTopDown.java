import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #5
    Test: swapMinMax
    Stubs: minValueIndex,maxValueIndex,copyArr
 */
@RunWith(Parameterized.class)
public class swapMinMaxTopDown {
    private Program p;
    private int[] arr1;
    private int[] expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2},new int[]{2, 1}},
                {new int[]{1, 4, 3},new int[]{4, 1, 3}},
                {new int[]{},null}
        });
    }

    public swapMinMaxTopDown(int[] arr1, int[] expectedOutput) {
        this.p = new ProgramStub();
        this.arr1 = arr1;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void swapMinMax() {
        assert(arr1!= p.swapMinMax(arr1));
        assertArrayEquals(expectedOutput,p.swapMinMax(arr1));
    }

    static class ProgramStub extends Program {
        //stub copyArr
        public int[] copyArr(int[] arr) {
            return arr == null ? null : arr.clone();
        }
        //stun minValueIndex
        public int minValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            return 0;
        }
        //stub maxValueIndex
        public int maxValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            return 1;
        }
    }
}