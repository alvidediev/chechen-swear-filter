package by.dediev;


import by.dediev.chechenswearfilter.ChechenSwearFilter;
import by.dediev.chechenswearfilter.ChechenSwearFilterImpl;
import org.junit.Assert;
import org.junit.Test;

public class ChechenSwearFilterTest {

    @Test
    public void test_swear_one_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertTrue(filter.containsSwear("буд"));
    }

    @Test
    public void test_swear_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertTrue(filter.containsSwear("буд привет как дела"));
    }

    @Test
    public void test_no_swear_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertFalse(filter.containsSwear("привет как дела"));
    }

    @Test
    public void test_censor_one_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertEquals("***", filter.censorText("буд"));
    }

    @Test
    public void test_censor_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertEquals("Привет ***", filter.censorText("Привет буд"));
    }

    @Test
    public void test_censor_no_word() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertEquals("Привет. Как дела ?", filter.censorText("Привет. Как дела ?"));
    }

    @Test
    public void test_censor_with_another_register() {
        ChechenSwearFilter filter = new ChechenSwearFilterImpl();
        Assert.assertEquals("***", filter.censorText("бУд"));
    }

}
