package lesson4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTests {
    Functions functions = new Functions();

    @Test
    void testIsNumberEvenThenTrueAssertJ () {
        assertThat(Functions.isNumberEven(5)).isFalse();
    }
    @Test
    void testCollection() {
        List<String> list = new ArrayList<>(Arrays.asList("test1", "test22", "test333"));
        assertThat(list).containsAnyOf("test1", "yyyy");
        assertThat(1).isLessThan(2).isGreaterThan(0);
    }
}
