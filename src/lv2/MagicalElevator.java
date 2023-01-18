package lv2;

import java.util.ArrayList;

//마법의 엘레베이터
public class MagicalElevator {

  public static class Solution {
    public int solution( int storey ) {
      int answer = 0;
// 3 4 6 7 10 11 12
      String temp = String.valueOf( storey );
//      if( temp.length() < 2 ) {
//        if( storey <= 5 ) {
//          return storey;
//        } else {
//          return 10 - ( storey ) + 1;
//        }
//      }

      int count = 0;
      for( int i = temp.length() - 1; i > 0; i-- ) {
        Character ch = temp.charAt( i );
        int num1 = Integer.parseInt( String.valueOf( ch ) ) + count;
        int num2 = Integer.parseInt( String.valueOf( temp.charAt( i - 1) ) );

        if( num1 == 5 ) {
          if( num2 >= 5 ) {
            answer += 10 - num1;
            count = 1;
          } else {
            answer += num1;
            count = 0;
          }
        } else if( num1 < 5) {
          answer += num1;
          count = 0;
        } else {
          answer += 10 - num1;
          count = 1;
        }

        System.out.println( "A = " + answer + " I = " + i + " NUM1 = " + num1 );
        if( ( i - 1 ) == 0 ) {
          System.out.println( "N1 = " + num1 + " N2 = " + num2 + " COUNT = " + count );
          if( num2 >= 5 ) {
            answer += 10 - num2;
          } else {
            answer += num2 + count;
          }
        }
      }

//      ArrayList<Integer> arrayList = new ArrayList<>();
//      int n = 0;
//      while( true ) {
//        n = storey % 10;
//        arrayList.add( n );
//        if( storey < 10 ) {
//          break;
//        }
//        storey = storey / 10;
//      }
//
//      int count = 0;
//      for( int i = 0; i < arrayList.size(); i++ ) {
//        if( arrayList.get( i ) < 5 ) {
//          answer += arrayList.get( i ) + count;
//          System.out.println( answer );
//          count = 0;
//          continue;
//        }
//        int t = 10 - arrayList.get( i ) - count;
//        answer += t;
//        System.out.println( answer );
//        count = 1;
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
    int storey6 = 5;

    int result = solution.solution( storey6 );
    System.out.println( "RESULT = " + result );
  }
}
