package polish_notation_task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReversePolishNotationCalculatorTest {
    private ReversePolishNotationCalculator calculator;

    @BeforeEach
    void createCalculator() {
        calculator = new ReversePolishNotationCalculator();
    }
    @Test
    void shouldCalculateAddition() {
        int addResult = calculator.calculatePolishNotation("4 3 +");
        assertEquals(7, addResult);
    }

    @Test
    void shouldCalculateAdditionSubtraction() {
        int subtractionResult = calculator.calculatePolishNotation("4 3 -");
        assertEquals(1, subtractionResult);
    }

    @Test
    void shouldCalculateAdditionMultiplying() {
        int multiplyingResult = calculator.calculatePolishNotation("4 3 *");
        assertEquals(12, multiplyingResult);
    }

    @Test
    void shouldConsiderNegativeNums() {
        int negativeResult = calculator.calculatePolishNotation("-4 3 +");
        assertEquals(-1, negativeResult);
    }

    @Test
    void shouldCalculateManyNums() {
        int result = calculator.calculatePolishNotation("1 2 3 - +");
        assertEquals(0, result);
    }

    @Test
    void shouldConsiderExtraSpaces() {
        int result = calculator.calculatePolishNotation("4   3  +");
        assertEquals(7, result);
    }
}

