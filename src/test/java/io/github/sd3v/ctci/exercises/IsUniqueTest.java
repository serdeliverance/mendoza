package io.github.sd3v.ctci.exercises;

import static io.github.sd3v.ctci.exercises.IsUnique.solution1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsUniqueTest {

  @Test
  public void whenStringIsUnitque_shouldReturnTrue() {
    var result = solution1("hola");
    assertEquals(true, result);
  }

  @Test
  public void whenStringIsNotUnique_shouldReturnFalse() {
    var result = solution1("pepo");
    assertEquals(false, result);
  }
}
