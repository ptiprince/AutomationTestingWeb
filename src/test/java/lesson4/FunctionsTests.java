package lesson4;

import lesson4.utils.TimingExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static lesson4.Functions.areaGeron;
import static lesson4.Functions.isNumberEven;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

//Logging
@ExtendWith(TimingExtension.class)
public class FunctionsTests {
    Functions functions = new Functions();
    //creating logging - fer more info look https://www.baeldung.com/logback
private static Logger logger = LoggerFactory.getLogger(FunctionsTests.class);

//Debug settings added for logging (could be error or info used instead (change settings in logback.xml for this
    @BeforeAll
    static void beforeAll() {
        logger.debug("Logged on debug level");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Precondition before each test");
    }

    @Test
    void areaGeronTest() throws WrongTriangleException {
        double result = areaGeron(2, 3, 4);
        Assertions.assertEquals(2.9047375096555625, result);
    }

    @Test
    void areaGeronException() {
        assertThatExceptionOfType(WrongTriangleException.class).isThrownBy(
                () -> areaGeron(1, 1, 3));
    }

    @Test
    void testIsNumberEvenThenTrue () {
        boolean result = isNumberEven(2);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Testing method isPrime with Prime Number")
    //@RepeatedTest(n) - annotation if test repeats n times
    void testNotPrimeNumber() {
        Assertions.assertFalse(functions.isPrime(4));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123321", "12344321"})
    void testIsPalindrome(String word) {
        Assertions.assertTrue(functions.isPalindrome(word));
    }

    @ParameterizedTest
    @CsvSource({"123321, true", "2344325, false"})
    void testIsPalindromeSet(String word, boolean result) {
      Assertions.assertEquals(functions.isPalindrome(word), result);
    }

    @ParameterizedTest
    @MethodSource("testParametrizedByObject")
    void testParametrizedByObject(Cat cat, Boolean result) {
        System.out.println(cat);
    }

    private static Stream<Arguments> testParametrizedByObject() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(new Cat("Versace", 8), true),
                Arguments.of(new Cat("Nicholas", 88), false)
        );
    }



    @AfterEach
    void tearDown() {
        System.out.println("Test executed, cleaning data after test");
    }

    @AfterAll
            static void afterAll() {
        System.out.println("Cleaning data after execution all tests");
    }
}
