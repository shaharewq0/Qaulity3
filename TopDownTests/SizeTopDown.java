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
    Test #14
    Test: isSorted, merge, printSorted, sumMinMax, swapMinMax
    Real Functions: All Program
    Stubs: None
 */
@RunWith(Parameterized.class)
public class SizeTopDown {
    private Program p;
    private TestType type;
    private int[] arr1;
    private int[] arr2;
    private Object expectedOutput;

    enum TestType { //used to define parameters for each test
        isSorted, merge, printSorted, copy,maxIndex,minIndex,size,swap,sum
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //isSorted parameters
                {TestType.isSorted, new int[]{1, 2, 3, 4}, null, true},
                {TestType.isSorted, new int[]{3, 2, 4, 1}, null, false},
                {TestType.isSorted, new int[]{}, null, true},

                {TestType.size,new int[]{1, 2},null,0},
                {TestType.size,new int[]{},null,0},

                {TestType.sum,new int[]{1, 2},null,3},
                {TestType.sum,new int[]{1, 4, 3},null,5},
                {TestType.sum,new int[]{1},null,2},

                {TestType.minIndex,new int[]{1, 2},null,0},
                {TestType.minIndex,new int[]{0, -1, 3},null,1},
                {TestType.minIndex,new int[]{},null,-1},

                {TestType.maxIndex,new int[]{1, 2},null,1},
                {TestType.maxIndex,new int[]{0, -1, 3},null,2},
                {TestType.maxIndex,new int[]{},null,-1},

                {TestType.copy,new int[]{1, 2,3,4},null,0},

                {TestType.swap,new int[]{1, 2},new int[]{2, 1},0},
                {TestType.swap,new int[]{1, 4, 3},new int[]{4, 1, 3},0},
                {TestType.swap,new int[]{},null,0},

                //merge parameters
                {TestType.merge, new int[]{1, 2}, new int[]{3, 4}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{4, 3, 2}, new int[]{1}, new int[]{1, 2, 3, 4}},
                {TestType.merge, new int[]{3, 2, 4, 1}, null, new int[]{1, 2, 3, 4}},
                {TestType.merge, null, new int[]{3, 2, 4, 1}, new int[]{1, 2, 3, 4}},
                {TestType.merge, null, null, null},

                //printSorted parameters
                {TestType.printSorted, new int[]{1, 2, 3, 4}, null, "1 2 3 4 \r\n1 2 3 4 \r\n1 2 3 4 \r\n"},
                {TestType.printSorted, new int[]{3, 2, 4, 1}, null, "3 2 4 1 \r\n1 2 3 4 \r\n3 2 4 1 \r\n"},
                {TestType.printSorted, new int[]{}, null, "\r\n\r\n\r\n"},
                {TestType.printSorted, null, null, "No array\r\n"}
        });
    }

    public SizeTopDown(TestType type, int[] arr1, int[] arr2, Object expectedOutput) {
        this.p = new Program();
        this.type = type;
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void swapMinMax() {
        if(type==TestType.swap) {
            assert (arr1 != p.swapMinMax(arr1));
            assertArrayEquals(arr2, p.swapMinMax(arr1));
        }
    }

    @Test
    public void sumMinMax() {
        if(type==TestType.sum) {
            assertEquals(expectedOutput, p.sumMinMax(arr1));
        }
    }

    @Test
    public void size() {
        if(type==TestType.size) {
            assertEquals(arr1.length,p.size(arr1));
        }
    }


    @Test
    public void minValueIndex() {
        if(type==TestType.minIndex) {
            assertEquals(expectedOutput,p.minValueIndex(arr1));
        }
    }

    @Test
    public void maxValueIndex() {
        if(type==TestType.maxIndex) {
            assertEquals(expectedOutput,p.maxValueIndex(arr1));
        }
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
}

