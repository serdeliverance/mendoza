package io.github.mendoza.learning.corejava.threads;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ComplexCalculationTest {

    @Test
    void complexCalculation() throws InterruptedException {
        ComplexCalculation subject = new ComplexCalculation();
        BigInteger result = subject.calculateResult(new BigInteger("2"), new BigInteger("3"), new BigInteger("10"), new BigInteger("5"));

        assertThat(result).isEqualTo(new BigInteger("100008"));
    }
}