package io.github.mendoza.aoc2024.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

  // TODO write unit tests for this method
  // TODO refactor this method (no suggestions provide, make it look nicer)
  public List<String> readFileAsListOfStrings(String filePath) {
    // TODO study this class loader, getResourceAsStream and input handling
    InputStream inputStream = FileParser.class.getClassLoader().getResourceAsStream(filePath);
    try {
      return readFromInputStream(inputStream);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // TODO write unit tests for this method
  public List<List<String>> readFileAsTwoListsOfStrings(String filePath) {
    var lines = readFileAsListOfStrings(filePath);

    // TODO study this regex
    Pattern pattern = Pattern.compile("(\\d+)\\s+(\\d+)");

    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    for (String line : lines) {
      Matcher matcher = pattern.matcher(line);

      if (matcher.matches()) {
        String firstValue = matcher.group(1);
        String secondValue = matcher.group(2);

        listOne.add(firstValue);
        listTwo.add(secondValue);
      }
    }

    return List.of(listOne, listTwo);
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
