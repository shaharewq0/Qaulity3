import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
    Test #13
    Test: isSorted, merge, printSorted,copyArr,swapMinMax
    Real Functions: printArr, equalArrays, sortArray, copyArr
    Stubs: size
 */
@RunWith(Parameterized.class)
public class CopyArrTopDown {
    private Program p;
    private TestType type;
    private int[] arr1;
    private int[] arr2;
    private Object expectedOutput;

    enum TestType { //used to define parameters for each test
        isSorted, merge, printSorted,swap,copy
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //isSorted parameters
                {TestType.isSorted, new int[]{1, 2, 3, 4}, null, true},
                {TestType.isSorted, new int[]{3, 2, 4, 1}, null, false},
                {TestType.isSorted, new int[]{4, 3, 2, 1}, null, false},
                {TestType.isSorted, new int[]{1, 2, 1, 2}, null, false},
                {TestType.isSorted, new int[]{}, null, true},
                {TestType.isSorted, new int[]{1}, null, true},

                {TestType.copy,new int[]{1, 2,3,4},null,0},

                //swap
                {TestType.swap,new int[]{1, 3,2,2},new int[]{3, 1,2,2},0},
                {TestType.swap,new int[]{1, 4, 3,2},new int[]{4, 1, 3,2},0},
                {TestType.swap,new int[]{},null,0},

                //merge parameters
                {TestType.merge, new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{3, 2}, new int[]{4, 1}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{4, 3, 2}, new int[]{1}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{3, 2, 4, 1}, null, new int[]{1, 2, 3, 4}},
                {TestType.merge, null, new int[]{3, 2, 4, 1}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{}, new int[]{}, new int[]{}},
                {TestType.merge, null, null, null},

                //printSorted parameters
                {TestType.printSorted, new int[]{1, 2, 3, 4}, null, "1 2 3 4 \r\n1 2 3 4 \r\n1 2 3 4 \r\n"},
                {TestType.printSorted, new int[]{3, 2, 4, 1}, null, "3 2 4 1 \r\n1 2 3 4 \r\n3 2 4 1 \r\n"},
                {TestType.printSorted, new int[]{4, 3, 2, 1}, null, "4 3 2 1 \r\n1 2 3 4 \r\n4 3 2 1 \r\n"},
                {TestType.printSorted, new int[]{1, 2, 1, 2}, null, "1 2 1 2 \r\n1 1 2 2 \r\n1 2 1 2 \r\n"},
                {TestType.printSorted, new int[]{}, null, "\r\n\r\n\r\n"},
                {TestType.printSorted, new int[]{1}, null, "1 \r\n1 \r\n1 \r\n"},
                {TestType.printSorted, null, null, "No array\r\n"}
        });
    }

    public CopyArrTopDown(TestType type, int[] arr1, int[] arr2, Object expectedOutput) {
        this.p = new ProgramStub();
        this.type = type;
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void copyArr() {
        if(type == TestType.copy)
            assert (arr1 != p.copyArr(arr1));
    }

    @Test
    public void isSorted() {
        if(type == TestType.isSorted)
            assertEquals(expectedOutput, p.isSorted(arr1));
    }

    @Test
    public void merge() {
        if(type == TestType.merge)
            assertArrayEquals((int[]) expectedOutput, p.merge(arr1, arr2));
    }

    @Test
    public void printSorted() {
        if(type == TestType.printSorted) {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            p.printSorted(arr1);
            assertEquals(expectedOutput, outContent.toString());
        }
    }

    @Test
    public void swapMinMax() {
        if(type==TestType.swap) {
            int[]temp=p.swapMinMax(arr1);
            assert (arr1 != temp);
            assertArrayEquals(arr2,temp);
        }
    }


    static class ProgramStub extends Program {
        /* stub for size */
        public int size(int[] arr) {
            if(Arrays.equals(arr, new int[]{}))
                return 0;
            if(Arrays.equals(arr, new int[]{1}))
                return 1;
            return 4;
        }
    }
}
