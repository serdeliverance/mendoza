package io.github.mendoza.aoc2024.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

  // TODO refactor this method (no suggestions provide, make it look nicer)
  public List<String> readFileAsListOfStrings(String filePath) {
    InputStream inputStream = FileParser.class.getClassLoader().getResourceAsStream(filePath);
    try {
      return readFromInputStream(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private List<String> readFromInputStream(InputStream inputStream) throws IOException {
    var lines = new ArrayList<String>();
    try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        lines.add(line);
      }
    }
    return lines;
  }
}
