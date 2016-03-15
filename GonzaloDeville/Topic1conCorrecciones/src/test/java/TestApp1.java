import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by cota on 26/02/16.
 */
public class TestApp1 {

    @Test
    public void testPrintHelloWorld() {

        Assert.assertEquals(App.getHelloWorld(), "Hello World");

    }

}
