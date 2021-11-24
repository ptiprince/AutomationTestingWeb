package lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionsTests {
    //created to check test preconditions: if preconditions did not meet test would not fall
    @Test
    void testAssumption() {
        assumeTrue(1 == 2);
        assertEquals(1, 2);
    }
    @Test
    void assertAllTests() {
        assertAll(
                ()  -> assertTrue(true),
                () -> assertEquals(1, 2),
                () -> assertEquals(1, 3),
                () -> assertFalse(false)
        );
    }
}
