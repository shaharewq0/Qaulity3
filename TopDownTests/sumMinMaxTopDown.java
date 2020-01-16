import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/*
    Test #4
    Test: sumMinMax
    Stubs: minValue,maxValue
 */
@RunWith(Parameterized.class)
public class sumMinMaxTopDown {
    private Program p;
    private int[] arr1;
    private int expectedOutput;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1, 2},3},
                {new int[]{2, 1},3},
                {new int[]{1, 2, 3},4},
                {new int[]{1},2}
        });
    }

    public sumMinMaxTopDown(int[] arr1, int expectedOutput) {
        this.p = new ProgramStub();
        this.arr1 = arr1;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void sumMinMax() {
        assertEquals(expectedOutput, p.sumMinMax(arr1));
    }

    static class ProgramStub extends Program {
        //stub minValue
        public int minValue(int[] arr) {
            int min=999;
            for(int i=0;i<arr.length;i++){
                if(arr[i]<min){
                    min=arr[i];
                }
            }
            return min;
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