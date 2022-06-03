package lv1;

import java.util.ArrayList;

public class MakeStrangeWord {
  public static class Solution {
    public String solution( String s ) {
      String answer = "";

      String[] array = s.split( " ", -1 );
      ArrayList<String> list = new ArrayList<String>();
      StringBuilder sb  = new StringBuilder();

      for( int i = 0; i < array.length; i++ ) {
        if( !array[i].equals( " " ) ) {
          for( int j = 0; j < array[i].length(); j++ ) {
            if( j % 2 == 0 ) {
              String oriWorld = array[i].substring( j , j + 1 );
              String newWorld = array[i].substring( j , j + 1 ).toUpperCase();
              sb.append( newWorld );
            } else {
              String oriWorld = array[i].substring( j , j + 1 );
              String newWorld = array[i].substring( j , j + 1 ).toLowerCase();
              sb.append( newWorld );
            }
          }
        } else {
          sb.append( array[i] );
        }
        if( i != array.length -1 ) {
          sb.append( " " );
        }
        list.add( sb.toString() );
      }

      answer = list.get( list.size() - 1 );
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "try hello world";

    String result = solution.solution( s );

    System.out.println( "RESULT = " + result );
  }
}
