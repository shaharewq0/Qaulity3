import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #1
    Test: printSorted
    Stubs: printArr, sortArray
 */
@RunWith(Parameterized.class)
public class PrintSortedTopDown {
    private Program p;
    private int[] arr;
    private String expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4}, "TTT"},
                {new int[]{3, 2, 4, 1}, "FTF"},
                {new int[]{4, 3, 2, 1}, "FTF"},
                {new int[]{1, 2, 1, 2}, "FTF"},
                {new int[]{}, "TTT"},
                {new int[]{1}, "TTT"},
                {null, "No array\r\n"}
        });
    }

    public PrintSortedTopDown(int[] arr, String expectedOutput) {
        this.p = new ProgramStub();
        this.arr = arr;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void printSorted() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        p.printSorted(arr);

        assertEquals(expectedOutput, outContent.toString());
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

        /*
            stub for printArr.
            print 'T' if arr sorted and 'F' otherwise.
         */
        @Override
        public void printArr(int[] arr) {
            if(arr == null)
                return;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    System.out.print("F");
                    return;
                }
            }
            System.out.print("T");
        }

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

