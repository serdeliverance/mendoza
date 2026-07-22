package io.github.mendoza.katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpandStringTest {

    @Test
    public void test() {
        String result = ExpandString.expandString("2[ab]3[c]1[d]");
        assertThat(result).isEqualTo("ababcccd");
    }
}