import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        sizeBottomUp.class,
        printArrBottomUp.class,

        equalArraysBottomUp.class,
        copyArrBottomUp.class,
        maxValueIndexBottomUp.class,
        minValueIndexBottomUp.class,

        sortArrayBottomUp.class,
        swapMinMaxBottomUp.class,
        minValueBottomUp.class,
        maxValueBottomUp.class,

        sumMinMaxBottomUp.class,
        isSortedBottomUp.class,
        mergeBottomUp.class,
        printSortedBottomUp.class
})
public class BottomUp {
}
