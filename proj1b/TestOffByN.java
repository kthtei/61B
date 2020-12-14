import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN;

    @Test
    public void testOffByN() {
        offByN = new OffByN(3);
        assertTrue(offByN.equalChars('a', 'd'));
        assertTrue(offByN.equalChars('g', 'j'));
        assertTrue(offByN.equalChars('z', 'w'));
        assertFalse(offByN.equalChars('a', 'a'));
    }
}


