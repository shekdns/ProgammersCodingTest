package lv1.kakao;

public class KeyPad {
  public static class Solution {
    public String solution( int[] numbers, String hand ) {
      String answer     = "";
      StringBuilder sb  = new StringBuilder();
      int lp = 10;
      int rp = 12;

      for( int i = 0; i < numbers.length; i++ ) {
        if( numbers[i] == 0 ) {
          numbers[i] = 11;
        }
        if( numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7 ) {
          lp = numbers[i];
          sb.append( "L" );
        } else if( numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9 ) {
          rp = numbers[i];
          sb.append( "R" );
        } else {
          if( i == 0 ) {
            if( hand.equals( "left") ) {
              lp = numbers[i];
              sb.append( "L" );
            } else {
              rp = numbers[i];
              sb.append( "R" );
            }
          } else {
            int lpp = Math.abs( lp - numbers[i] );
            int rpp = Math.abs( rp - numbers[i] );

            int l = ( lpp % 3 ) + ( lpp / 3 );
            int r = ( rpp % 3 ) + ( rpp / 3 );

            if( r > l ) {
              sb.append( "L" );
              lp = numbers[i];
            } else if( r == l ) {
              if( hand.equals( "right" ) ) {
                sb.append( "R" );
                rp = numbers[i];
              } else {
                sb.append( "L" );
                lp = numbers[i];
              }
            } else {
              sb.append( "R" );
              rp = numbers[i];
            }
          }
        }
      }

      answer = sb.toString();
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
    String hand   = "right";

    String result = solution.solution( numbers, hand );

    System.out.println( "RESULT = " + result );
  }
}
