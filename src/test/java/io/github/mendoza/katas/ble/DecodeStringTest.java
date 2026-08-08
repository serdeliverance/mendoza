package io.github.mendoza.katas.ble;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DecodeStringTest {

    @Test
    public void test() {
        String result = DecodeString.solution("3[abc2[de]]");

        assertThat(result).isEqualTo("abcdedeabcdedeabcdede");
    }

    @Test
    public void test_2() {
        String result = DecodeString.solution("ab4[k]c2[ab3[n]]z");

        assertThat(result).isEqualTo("abkkkkcabnnnabnnnz");
    }

    @Test
    public void test_3() {
        String result = DecodeString.solution("az");

        assertThat(result).isEqualTo("az");
    }
}