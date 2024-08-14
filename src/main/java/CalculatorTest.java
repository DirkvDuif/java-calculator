import calculator.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(6, Calculator.add(1, 5));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertEquals(-1, Calculator.subtract(1, 2));
    }
}