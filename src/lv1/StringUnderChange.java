package lv1;

import java.util.Arrays;
import java.util.Collections;

public class StringUnderChange {
  public static class Solution {
    public String solution(String s) {
      String answer = "";

      String[] string = new String[s.length()];

      for( int i = 0; i < s.length(); i++ ) {
        Character ch = s.charAt( i );
        string[i] = String.valueOf( ch );
      }

      Arrays.sort( string, Collections.reverseOrder() );

      StringBuilder sb = new StringBuilder();

      for( String ss : string ) {
        sb.append( ss );
      }
      answer = sb.toString();
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "Zbcdefg";

    String result = solution.solution( s );
    System.out.println( result );
  }
}