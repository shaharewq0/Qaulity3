import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #3
    Test: merge
    Stubs: sortArray
 */
@RunWith(Parameterized.class)
public class MergeTopDown {
    private Program p;
    private int[] arr1;
    private int[] arr2;
    private int[] expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4}},
                {new int[]{4, 3, 2}, new int[]{1}, new int[]{1, 2, 3, 4}},
                {new int[]{3, 2, 4, 1}, null, new int[]{1, 2, 3, 4}},
                {null, new int[]{3, 2, 4, 1}, new int[]{1, 2, 3, 4}},
                {null, null, null}
        });
    }

    public MergeTopDown(int[] arr1, int[] arr2, int[] expectedOutput) {
        this.p = new ProgramStub();
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void merge() {
        assertArrayEquals(expectedOutput, p.merge(arr1, arr2));
    }

    static class ProgramStub extends Program {
        private static int[][][] sortedArrays =
            new int[][][]{
                {{1, 2, 3, 4}, {1, 2, 3, 4}},
                {{3, 2, 4, 1}, {1, 2, 3, 4}},
                {{4, 3, 2, 1}, {1, 2, 3, 4}},
            }; //used to simulate sorting

        /* stub for sortArray */
        @Override
        public int[] sortArray(int[] arr) {
            for (int[][] arrPair: sortedArrays) {
                if(Arrays.equals(arr, arrPair[0]))
                    return arrPair[1];
            }
            return null;
        }
    }
}
