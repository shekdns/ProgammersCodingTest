package lv1;

import java.util.ArrayList;

//소수 구하기( 에라토스테네스의 체 )
public class Eratonic {
  public static class Solution {
    public int solution( int n ) {
      int answer = 0;

      ArrayList<Boolean> list = new ArrayList<>();

      if( n < 2 ) {
        return 0;
      }

      list.add( 0, false );
      list.add( 1, false );

      for( int i = 2; i <= n; i++ ) {
        list.add( i, true );
      }

      for( int i = 2; ( i * i ) <= n; i++ ) {
        if( list.get( i ) == true ) {
          for( int j = i * i; j <= n; j+= i ) {
            list.set( j, false );
          }
        }
      }

      StringBuilder sb = new StringBuilder();
      sb.append( "{" );
      for( int i = 0; i <= n; i++ ) {
        if( list.get( i ) == true ) {
          sb.append( i );
          sb.append( " " );
        }
      }
      sb.setCharAt( sb.length() - 1, '}' );

      System.out.println( sb.toString() );
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 10;

    System.out.println( "RESULT = " + solution.solution( n ) );
  }
}
