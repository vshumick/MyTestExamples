package testTasks210516;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    
    String[] inputs = {"ab", "aba", "aab", "baa"};
    for (String i : inputs) {
      System.out.println(i + "--> " + hasPalindrome(i));
    }
  }
  
  /**
   * Returns true if the input can be arranged into a palindrome.
   * E.g.
   * ab -> false
   * aba -> true
   * aab -> true (it can be arranged into aba)
   */  
  public static boolean hasPalindrome(String input) {
    if (input == null)
      return false;

    StringBuilder stringBuilder = new StringBuilder(input);
    stringBuilder.reverse();
    return input.equals(new String(stringBuilder));
  }
}
