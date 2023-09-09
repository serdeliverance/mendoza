package io.github.sd3v.ctci.explanations;

public class StringBuilderExample {

  /**
   * complexity is O(n2)... it comes from n(n + 1)/2
   *
   * <p>Each time we are appending a string, we are creating a new string and copy all previous
   * elements + new ones
   *
   * <p>so, if I have ["pepo", "hola", "rene"]... I will doing this:
   *
   * <p>1) var step1 = new char[] ("pepo") // creating new array and copying x elements 2) var step2
   * = new char[] ("pepohola") // creating new array and copying 2x elements 3) var step3 = new
   * char[] ("pepoholarene") // creating new array and copying 3x elements
   *
   * @param words
   * @return
   */
  String joinWords_old(String[] words) {
    String sentence = "";
    for (String w : words) {
      sentence = sentence + w;
    }
    return sentence;
  }

  String joinWords(String[] words) {
    var sb = new StringBuilder();
    for (String word : words) {
      sb.append(word);
    }
    return sb.toString();
  }
}
