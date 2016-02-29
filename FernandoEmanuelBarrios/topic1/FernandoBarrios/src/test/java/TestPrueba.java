import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cota on 26/02/16.
 */
public class TestPrueba {
    @Test
    public void testPrintHelloWord(){
        Assert.assertEquals(Prueba.getHelloWord(),"hello word");
    }
}
