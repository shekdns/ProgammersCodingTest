package lv2;

import java.util.LinkedHashMap;
import java.util.LinkedList;

//전력망을 둘로 나누기(완전탐색)
public class DivideTheGridInTwo {
  public static class Solution {
    public int solution( int n, int[][] wires ) {
      int answer = -1;

      LinkedHashMap<Integer,LinkedList<Integer>> lMap = new LinkedHashMap<>();
      for( int i = 1; i <= n; i++ ) {
        LinkedList<Integer> list = new LinkedList<>();
        for( int j = 0; j< wires.length; j++ ) {
          int startPoint = wires[j][0];
          int endPoint   = wires[j][1];
          if( startPoint == i ) {
            list.add( endPoint );
          }
          if( endPoint == i ) {
            list.add( startPoint );
          }
        }
        lMap.put( i, list );
      }

      System.out.println( lMap );

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n1 = 9;
    int n2 = 4;
    int n3 = 7;
    int[][] wires1 = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 }  };
    int[][] wires2 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
    int[][] wires3 = { { 1, 2 }, { 2, 7 }, { 3, 7 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };
    System.out.println( "RESULT = " + solution.solution( n3, wires3 ) );
  }
}
