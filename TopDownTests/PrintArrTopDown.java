import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #6
    Test: printSorted
    Real Functions: printArr
    Stubs: sortArray
 */
@RunWith(Parameterized.class)
public class PrintArrTopDown {
    private Program p;
    private int[] arr;
    private String expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2, 3, 4}, "1 2 3 4 \r\n1 2 3 4 \r\n1 2 3 4 \r\n"},
                {new int[]{3, 2, 4, 1}, "3 2 4 1 \r\n1 2 3 4 \r\n3 2 4 1 \r\n"},
                {new int[]{}, "\r\n\r\n\r\n"},
                {null, "No array\r\n"}
        });
    }

    public PrintArrTopDown(int[] arr, String expectedOutput) {
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
    }
}
