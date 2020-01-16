import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #9
    Test: minValue,sumMinMax
    Stubs: minValueIndex,maxValue
 */
@RunWith(Parameterized.class)
public class minValueTopDown {
    private Program p;
    private TestType type;
    private int[] arr1;
    private int expectedOutput;

    enum TestType { //used to define parameters for each test
        sum, min
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {

                {TestType.min,new int[]{1, 2},1},
                {TestType.min,new int[]{0, 1, 3},0},
                {TestType.min,new int[]{1},1},

                {TestType.sum,new int[]{1, 2},3},
                {TestType.sum,new int[]{0, 1, 3},3},
                {TestType.sum,new int[]{1},2}
        });
    }

    public minValueTopDown(TestType tp, int[] arr1, int expectedOutput) {
        this.p = new ProgramStub();
        type=tp;
        this.arr1 = arr1;
        this.expectedOutput = expectedOutput;
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
    public void sumMinMax() {
        if(type==TestType.sum)
            assertEquals(expectedOutput, p.sumMinMax(arr1));
    }

    static class ProgramStub extends Program {
        //stub minValueIndex
        public int minValueIndex(int[] arr) {
            if (arr.length==0) return -1;
            return 0;
        }
        //stub maxValue
        public int maxValue(int[] arr) {
            int max=-999;
            for(int i=0;i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                }
            }
            return max;
        }
    }
}