import org.junit.Test;

import static org.junit.Assert.*;


public class mergeBottomUp {

    @Test(timeout = 100)
    public void merge() {

        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge( new int[] {1,2,3}, new int[] {4,5,6})); // both sorted
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge( new int[] {1,2,3}, new int[] {5,4,6})); // only first sorted
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge( new int[] {2,1,3}, new int[] {4,5,6})); // only second sorted
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge( new int[] {2,1,3}, new int[] {5,4,6})); // both unsorted

        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(new int[] {2,1}, new int[] {5,4,3,6})); // different size
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(new int[] {5,4,3,6} ,new int[] {2,1})); // different size

        assertArrayEquals( new int[] {1,2,3,4,5,6,7}, Program.merge(new int[] {1,7,3,6} ,new int[] {2,4,5})); // sort(a1) + sort(a2) =/= sort(a1+a2)




        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(null, new int[] {6,1,5,3,2,4})); // first null
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(new int[] {6,1,5,3,2,4}, null)); // second null
        assertArrayEquals( null, Program.merge(null, null));                             // both null

        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(new int[] {}, new int[] {6,1,5,3,2,4})); // first empty
        assertArrayEquals( new int[] {1,2,3,4,5,6}, Program.merge(new int[] {6,1,5,3,2,4}, new int[] {})); // second empty
        assertArrayEquals( new int[] {}, Program.merge(new int[] {}, new int[] {}));                       // both empty

        assertArrayEquals( new int[] {}, Program.merge(new int[] {}, null)); // first empty, second null
        assertArrayEquals( new int[] {}, Program.merge(null, new int[] {})); // first null, second empty
    }
}
