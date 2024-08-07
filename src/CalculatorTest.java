import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(3, Calculator.add(new int[] { 1, 2, 3 }));
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertEquals(-1, Calculator.subtract(1, 2));
    }
}