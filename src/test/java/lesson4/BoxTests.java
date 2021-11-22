package lesson4;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import static org.assertj.core.api.Assertions.*;

public class BoxTests {
    static Box box;
//nested class for separating logic flows - for empty and not empty boxes.
//Can be broken on different classes too.

  @Nested
    class WhenBoxEmpty {
    @BeforeEach
    void createBox() {
        box = new Box();
    }

    @Test
    void checkExceptionWhenShuffle() {
        assertThatNullPointerException().isThrownBy(() -> box.suffleBalls());
    }

    @Test
    void testMyException() {
        assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.deleteBall());
    }
    @Nested
    class WhenBoxHasBalls {
        @BeforeEach
        void addBall() {
            box.getBallsCounter();
        }
        @Test
        void ballAdditionTest() {
            int ballsCount = box.getBallsCounter();
            box.addBall();;
            Assertions.assertEquals(box.getBallsCounter(), ballsCount + 1);
        }
    }
}
}
