import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #2
    Test: isSorted
    Stubs: equalArrays, sortArray
 */
@RunWith(Parameterized.class)
public class IsSortedTopDown {
    private Program p;
    private int[] arr;
    private boolean expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4}, true},
                {new int[]{3, 2, 4, 1}, false},
                {new int[]{}, true},
        });
    }

    public IsSortedTopDown(int[] arr, boolean expectedOutput) {
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
                        {{}, {}}
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

        /* stub for equalArrays */
        @Override
        public boolean equalArrays(int[] arr1, int[] arr2) {
            return Arrays.equals(arr1, arr2);
        }
    }

}
