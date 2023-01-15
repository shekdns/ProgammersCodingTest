package lv2;

import java.util.ArrayList;

//마법의 엘레베이터
public class MagicalElevator {

  public static class Solution {
    public int solution( int storey ) {
      int answer = 0;

      String temp = String.valueOf( storey );
      if( temp.length() < 2 ) {
        return storey;
      }

      ArrayList<Integer> arrayList = new ArrayList<>();
      int n = 0;
      while( true ) {
        n = storey % 10;
        arrayList.add( n );
        if( storey < 10 ) {
          break;
        }
        storey = storey / 10;
      }

      int count = 0;
      for( int i = 0; i < arrayList.size(); i++ ) {
        if( arrayList.get( i ) < 5 ) {
          answer += arrayList.get( i ) + count;
          System.out.println( answer );
          count = 0;
          continue;
        }
        int t = 10 - arrayList.get( i ) - count;
        answer += t;
        System.out.println( answer );
        count = 1;
      }

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
    int storey6 = 555;

    int result = solution.solution( storey6 );
    System.out.println( "RESULT = " + result );
  }
}
