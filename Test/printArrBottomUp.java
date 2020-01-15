import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class printArrBottomUp {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream screen = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreStreams() {
        System.setOut(screen);
    }


    @Test(timeout = 100)
    public void printArr() {

        Program.printArr(new int[] {2,1,3,4,6});
        assertEquals("2 1 3 4 6 \n", out.toString());

        out.reset();
        Program.printArr(new int[] {0});
        assertEquals("0 \n", out.toString());

        out.reset();
        Program.printArr(new int[] {});
        assertEquals("\n", out.toString());


        //TODO : Null?
        //TODO : space at the end? mew line?
    }
}
