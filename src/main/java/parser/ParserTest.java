package parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    void onlyPlusses() {
        assertEquals("1 6 + 5 +", parser.Parser.createReversePolishNotation("1+6+5"));
    }

    @Test
    void minusInFront() {
        assertEquals("-1 6 +", parser.Parser.createReversePolishNotation("-1+6"));
    }

    @Test
    void multiplication() {
        assertEquals("6 8 * 5 +", parser.Parser.createReversePolishNotation("6*8+5"));
    }

    @Test
    void parentheses() {
        assertEquals("8 3 6 + *", parser.Parser.createReversePolishNotation("8*(3+6)"));
    }

    @Test
    void multipleParentheses() {
        assertEquals("3 6 + 3 6 + *", parser.Parser.createReversePolishNotation("(3+6)*(3+6)"));
    }
}
