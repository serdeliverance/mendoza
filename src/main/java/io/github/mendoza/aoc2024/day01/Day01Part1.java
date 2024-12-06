package io.github.mendoza.aoc2024.day01;

import io.github.mendoza.aoc2024.utils.FileParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01Part1 {

  public static int solutionPart1(int[] listOne, int[] listTwo) {
    Arrays.sort(listOne);
    Arrays.sort(listTwo);
    int result = 0;
    for (int i = 0; i < listOne.length; i++) {
      result += Math.abs(listOne[i] - listTwo[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    FileParser fileParser = new FileParser();
    var lines = fileParser.readFileAsListOfStrings("day01/input_part1.txt");

    // TODO move this logic to utility method
    // TODO study this regex
    Pattern pattern = Pattern.compile("(\\d+)\\s+(\\d+)");

    ArrayList<Integer> listOne = new ArrayList<>();
    ArrayList<Integer> listTwo = new ArrayList<>();

    for (String line : lines) {
      Matcher matcher = pattern.matcher(line);

      if (matcher.matches()) {
        String firstValue = matcher.group(1);
        String secondValue = matcher.group(2);

        int firstValueAsInt = Integer.parseInt(firstValue);
        int secondValueAsInt = Integer.parseInt(secondValue);

        listOne.add(firstValueAsInt);
        listTwo.add(secondValueAsInt);
      }
    }

    int[] arrayOne = listOne.stream().mapToInt(Integer::intValue).toArray();
    int[] arrayTwo = listTwo.stream().mapToInt(Integer::intValue).toArray();

    var result = solutionPart1(arrayOne, arrayTwo);

    System.out.println(result);
  }
}
