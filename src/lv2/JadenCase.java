package lv2;

public class JadenCase {
  public static class Solution {
    public String solution( String s ) {
      String answer = "";

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String s1 = "3people unFollowed me";  // => 3people Unfollowed Me
    String s2 = "for the last week";      // => For The Last Week

    String result = solution.solution( s1 );
    System.out.println( "RESULT = " + result );
  }
}
