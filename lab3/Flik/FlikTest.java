import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlikTest {

    @Test
    public void horribleSteveTest() {
        Integer a = 127;
        Integer b = 127;
        assertTrue(Flik.isSameNumber(a, b));

        a++;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        assertFalse(Flik.isSameNumber(a, b));
    }
}
