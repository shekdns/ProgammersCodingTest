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

      int sum = 1;
      for( int i = 0; i < temp.length() -1; i++ ) {
        sum *= 10;
      }
      int tSum = sum *= ( arrayList.get( temp.length() - 1 ) + 1 );
      String last = String.valueOf( String.valueOf( tSum ).charAt( 0 ) );

      int count = 0;
      for( int i = 0; i < arrayList.size() - 1; i++ ) {
        if( arrayList.get( i ) < 5 ) {
          answer += arrayList.get( i );
          count = 0;
          continue;
        }
        int t = 10 - arrayList.get( i ) - count;
        answer += t;
        count = 1;
      }

      answer += Integer.valueOf( last );

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int storey1 = 16;
    int storey2 = 2554;
    int storey3 = 4;

    int result = solution.solution( storey2 );
    System.out.println( "RESULT = " + result );
  }
}
