import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/*
    Test #6
    Test: isSorted
    Real Functions: equalArrays
    Stubs: sortArray, size
 */
@RunWith(Parameterized.class)
public class EqualArraysTopDown {
    private Program p;
    private int[] arr;
    private boolean expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4}, true},
                {new int[]{3, 2, 4, 1}, false},
                {new int[]{4, 3, 2, 1}, false},
                {new int[]{1, 2, 1, 2}, false},
                {new int[]{}, true},
                {new int[]{1}, true},
        });
    }

    public EqualArraysTopDown(int[] arr, boolean expectedOutput) {
        this.p = new ProgramStub();
        this.arr = arr;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void isSorted() {
        assertEquals(expectedOutput, p.isSorted(arr));
    }


    static class ProgramStub extends Program {
        private static int[][][] sortedArrays =
                new int[][][]{
                        {{1, 2, 3, 4}, {1, 2, 3, 4}},
                        {{3, 2, 4, 1}, {1, 2, 3, 4}},
                        {{4, 3, 2, 1}, {1, 2, 3, 4}},
                        {{1, 2, 1, 2}, {1, 1, 2, 2}},
                        {{}, {}},
                        {{1}, {1}},
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

        /* stub for size */
        @Override
        public int size(int[] arr) {
            if(Arrays.equals(arr, new int[]{}))
                return 0;
            if(Arrays.equals(arr, new int[]{1}))
                return 1;
            return 4;
        }
    }

}
