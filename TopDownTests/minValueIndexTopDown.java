import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #11
    Test: minValueIndex,minValue,swapMinMax,sumMinMax
    Stubs: copyArr,size,maxValueIndex
 */
@RunWith(Parameterized.class)
public class minValueIndexTopDown {
    private Program p;
    private TestType type;
    private int[] arr1;
    private int[] arr2;
    private int expectedOutput;

    enum TestType { //used to define parameters for each test
        swap, min,index,sum
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {

                {TestType.index,new int[]{1, 2},null,0},
                {TestType.index,new int[]{0, -1, 3},null,1},
                {TestType.index,new int[]{},null,-1},

                {TestType.sum,new int[]{1, 2},null,3},
                {TestType.sum,new int[]{1, 4, 3},null,5},
                {TestType.sum,new int[]{1},null,2},

                {TestType.min,new int[]{1, 2},null,1},
                {TestType.min,new int[]{0, -1, 3},null,-1},
                {TestType.min,new int[]{1},null,1},

                {TestType.swap,new int[]{1, 2},new int[]{2, 1},0},
                {TestType.swap,new int[]{1, 4, 3},new int[]{4, 1, 3},0},
                {TestType.swap,new int[]{},null,0}
        });
    }

    public minValueIndexTopDown(TestType tp, int[] arr1,int[] arr2, int expectedOutput) {
        this.p = new ProgramStub();
        type=tp;
        this.arr1 = arr1;
        this.arr2=arr2;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void sumMinMax() {
        if(type==TestType.sum) {
            assertEquals(expectedOutput, p.sumMinMax(arr1));
        }
    }

    @Test
    public void minValueIndex() {
        if(type==TestType.index) {
            assertEquals(expectedOutput,p.minValueIndex(arr1));
        }
    }

    @Test
    public void minValue() {
        if(type==TestType.min) {
            int min=p.minValue(arr1);
            for(int i=0;i<arr1.length;i++) {
                assertTrue(arr1[i]>=min);
            }
            assertEquals(expectedOutput,min);
        }
    }
    @Test
    public void swapMinMax() {
        if(type==TestType.swap) {
            assert (arr1 != p.swapMinMax(arr1));
            assertArrayEquals(arr2, p.swapMinMax(arr1));
        }
    }

    static class ProgramStub extends Program {

        //stub copyArr
        public int[] copyArr(int[] arr) {
            return arr == null ? null : arr.clone();
        }


        //stub size
        public int size(int[] arr){return arr.length;}

        //stub maxValueIndex
        public int maxValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            if(arr.length==1) return 0;
            return 1;
        }
    }
}