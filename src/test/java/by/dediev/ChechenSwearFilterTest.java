package by.dediev;


import by.dediev.chechenswearfilter.ChechenSwearFilter;
import by.dediev.chechenswearfilter.ChechenSwearFilterImpl;
import org.junit.Assert;
import org.junit.Test;

public class ChechenSwearFilterTest {

    @Test
    public void test() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertTrue(filter.containsSwear("буд"));
    }

}
