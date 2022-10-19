package lv2;
//제이든 케이스
public class JadenCase {
  public static class Solution {
    public String solution( String s ) {
      String answer = "";
      int index = 0;
      s = s.toLowerCase();

      StringBuilder sb = new StringBuilder();

      for( int i = 0; i < s.length(); i++ ) {
        Character ch = s.charAt(i);
        String temp = ch.toString();
        index++;
        if( index == 1 ) {
          temp = ch.toString().toUpperCase();
          System.out.println( "CH = " + temp + " INDEX = " + index );
        }
        if( ch.toString().equals( " " ) ) {
          index = 0;
          System.out.println( "CCH = " + ch );
        }
        sb.append( temp );
      }

      answer = sb.toString();

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