

import org.junit.Test;

import com.Topic1.Boot;

import static org.junit.Assert.*;

public class BootTest {
	@Test
    public void testConcatenate() {
        Boot boot = new Boot();

        String result = boot.concatenate("one", "two");

        assertEquals("onetwo", result);

    }
}
