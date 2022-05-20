package lv1;

import java.util.Objects;

public class StringShift {
  public static class Solution {
    public String solution( String s, int n ) {
      String answer = "";

      s = s.replaceAll( " ", "?" );

      StringBuilder sb = new StringBuilder();
      for( int i = 0; i < s.length(); i++ ) {
        Character ch = s.charAt( i );
        String cch   = ch.toString();
        if( cch.equals( "?" ) ) {
          sb.append( " " );
          continue;
        }

        int asc = (int) ch;

        if( asc >= 65 && asc <= 90 ) {  //A~Z
          asc += n;

          if( asc > 90 ) {  //115  -> 89 26
            asc = asc - 26;
          }
        } else if( asc >= 97 && asc <= 122 ) { //a~z
          asc += n;

          if( asc > 122 ) {
            asc = asc - 26;
          }
        }
        ch = (char) asc;
        sb.append( ch );
      }

      answer = sb.toString();
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String string = "AaZz";  //ZzYy
    String result = "";

    result = solution.solution( string, 25 );
    System.out.println( "RESULT = " + result );
  }
}