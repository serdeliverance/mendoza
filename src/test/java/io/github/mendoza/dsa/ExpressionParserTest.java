package io.github.mendoza.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {

    private ExpressionParser parser = new ExpressionParser();

    @Test
    public void testSum() {
        var expression = "2 + 2";
        var result = parser.evaluate(expression);
        assertEquals(4, result);
    }
}