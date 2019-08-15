import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    HelloWorld hw;

    @Before
    public void setUp() {
        hw = new HelloWorld();
    }

    @Test
    public void testCamelCase() {
        assertEquals("helloWorld", hw.camelCase("hello world"));
        assertEquals("hello", hw.camelCase("hello"));
        assertEquals("hiHowAreYou", hw.camelCase("hi how are you"));
        assertEquals("", hw.camelCase(""));
    }
}
