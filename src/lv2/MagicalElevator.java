package lv2;

import java.util.ArrayList;
import java.util.Arrays;

//마법의 엘레베이터
public class MagicalElevator {

  public static class Solution {
    public int solution( int storey ) {
      int answer = 0;

      String temp = String.valueOf( storey );
      //String[] array = Arrays.stream(temp.split( "" )).map( String::toString ).toArray( String[]::new );
      Integer[] array = Arrays.stream(temp.split( "" )).map( Integer::parseInt ).toArray( Integer[]::new );

      for( int i = array.length - 1; i >= 0; i-- ) {
        int num = array[i];
        if( i > 0 && array[i] > 5 ) {
          num = 10 - array[i];
          array[i-1]++;
        }
        if( i > 0 && array[i] == 5 ) {
          num = 10 - array[i];
          if( array[i-1] >= 5 ) {
            array[i-1]++;
          }
        }
        if( i == 0 ) {
          if( num > 5 ) {
            num = 10 - num + 1;
          }
        }

        answer += num;
      }

//      int count = 0;
//      for( int i = temp.length() - 1; i > 0; i-- ) {
//        Character ch = temp.charAt( i );
//        int num1 = Integer.parseInt( String.valueOf( ch ) ) + count;
//        int num2 = Integer.parseInt( String.valueOf( temp.charAt( i - 1) ) );
//
//        if( num1 == 5 ) {
//          if( num2 >= 5 ) {
//            answer += 10 - num1;
//            count = 1;
//          } else {
//            answer += num1;
//            count = 0;
//          }
//        } else if( num1 < 5) {
//          answer += num1;
//          count = 0;
//        } else {
//          answer += 10 - num1;
//          count = 1;
//        }
//
//        System.out.println( "A = " + answer + " I = " + i + " NUM1 = " + num1 );
//        if( ( i - 1 ) == 0 ) {
//          System.out.println( "N1 = " + num1 + " N2 = " + num2 + " COUNT = " + count );
//          if( num2 >= 5 ) {
//            if( num2 == 9 && count == 0 ) {
//              answer += 10 - num2 + 1;
//            } else if ( num2 == 5 ) {
//              answer += count;
//            } else {
//              answer += 10 - num2;
//            }
//          } else {
//            answer += num2 + count;
//          }
//        }
//      }



      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int storey1 = 16;
    int storey2 = 2554;
    int storey3 = 4;
    int storey4 = 95;
    int storey5 = 11;
    int storey6 = 5555;

    int result = solution.solution( storey2 );
    System.out.println( "RESULT = " + result );
  }
}
