package io.github.sd3v.ctci.exercises;

import static io.github.sd3v.ctci.exercises.IsPermutation.isPermutation;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsPermutationTest {

  @Test
  public void whenIsPermutation_shouldReturnTrue() {
    var result = isPermutation("volker", "rlokev");
    assertEquals(true, result);
  }

  @Test
  public void whenAllCharactersInTheSameOrder_shouldReturnFalse() {
    var result = isPermutation("hola", "hola");
    assertEquals(false, result);
  }

  @Test
  void whenIsNotPermutation_shouldReturnFalse() {
    var result = isPermutation("hola", "holi");
    assertEquals(false, result);
  }
}
