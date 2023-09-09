package io.github.sd3v.ctci.dsa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;

class HashTableTest {

  @Test
  public void whenKeyExists_shouldReturnValue() {
    var hashTable = new HashTable();

    hashTable.put("secretKey", "pass1234");

    var result = hashTable.get("secretKey");

    assertEquals(result, Optional.of("pass1234"));
  }

  @Test
  public void whenKeyNotExists_shouldReturnEmpty() {
    var hashTable = new HashTable();

    hashTable.put("pokemon", "Pikachu");

    var result = hashTable.get("unexistingKey");

    assertEquals(result, Optional.empty());
  }
}
