package io.github.mendoza.misc;

import org.junit.jupiter.api.Test;

import static io.github.mendoza.misc.ValidParenthesis.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    @Test
    public void testValid() {
        String s = "()[]{}{}";
        boolean result = validParenthesis(s);
        assertTrue(result);
    }

    @Test
    public void testValid_2() {
        String s = "([]){}";
        boolean result = validParenthesis(s);
        assertTrue(result);
    }

    @Test
    public void testInvalid() {
        String s = "(]]]]";
        boolean result = validParenthesis(s);
        assertFalse(result);
    }
}