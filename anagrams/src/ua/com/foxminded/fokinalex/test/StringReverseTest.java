package ua.com.foxminded.fokinalex.test;


import  ua.com.foxminded.fokinalex.anagrams.StringReverse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringReverseTest {

    StringReverse reverse;

    @BeforeEach
    void init() {
        reverse = new StringReverse();
    }

    @ParameterizedTest
    @CsvSource({"'',''", "a,a", "ba,ab", "drow,word", "serugiF123,Figures123"})
    @DisplayName("testReversesWordWithDifferentParameters")
    void testWithWordParameter(String expected, String actual) {
        assertEquals(expected, reverse.reversesWord(actual));
    }

    @Test
    @DisplayName("testReversWordShouldReturnStringWithSameLength")
    void testReversWordShouldReturnStringWithSameLength(){
        String preparedTestString = "   word      ";
        int expected = preparedTestString.length();

        String actual = reverse.reversesWord(preparedTestString);

        assertEquals(expected, actual.length());
    }

    @Test
    @DisplayName("testReversesWordThrowExceptionOnNull")
    void testReversesWordShouldThrowExceptionOnNull() {
        assertThrows(IllegalArgumentException.class,
                () -> reverse.reversesWord(null));
    }

    @ParameterizedTest
    @CsvSource({"'',''", "a,a", "cba fed,abc def", "ba dc fe,ab cd ef",
            "!,!", "![],![]", "aa,aa", "gDfA,AfDg", "rdnaskela"})

    @DisplayName("testReverseAlphabeticCharsOnlyWithDifferentParameters")
    void testWithExplicitArgumentConversion(String expected, String actual) {
        assertEquals(expected, reverse.reverseAlphabeticCharsOnly(actual));

    }

    @Test
    @DisplayName("testReverseAlphabeticCharsOnlyThrowExceptionOnNull")
    void testReverseAlphabeticCharsOnlyShouldThrowExceptionOnNull() {
        assertThrows(IllegalArgumentException.class,
                () -> reverse.reverseAlphabeticCharsOnly(null)
        );
    }

    @Test
    @DisplayName("testReverseAlphabeticShouldReturnStringWithSameLength")
    void testReverseAlphabeticShouldReturnStringWithSameLength() {
        String preparedTestString = "   abSc34!@    ddf34f    ";
        int expected = preparedTestString.length();

        String actual = reverse.reverseAlphabeticCharsOnly(preparedTestString);

        assertEquals(expected, actual.length());
    }


}