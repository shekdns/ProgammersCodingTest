package lv2;

import java.util.*;

//전력망을 둘로 나누기(완전탐색)
public class DivideTheGridInTwo {
  public static class Solution {

    public int getBfsNum( int index, int[][] wires ) {
      int count = 0;

      List<int[]> list = new ArrayList<>();
      for( int[] temp : wires ) {
        list.add( temp );
      }

      Queue<Integer> queue = new LinkedList<>();
      queue.add( list.get( index )[0] );
      list.remove( index );

      while( !queue.isEmpty() ) {
        int check = queue.remove();
        for( int i = 0; i < list.size(); i++ ) {
          int[] array = list.get(i);
          if( check == array[1] ) {
            queue.add( list.get(i)[0] );
            list.remove( array );
            i--;
          }
          if( check == array[0] ) {
            queue.add( list.get(i)[1] );
            list.remove( array );
            i--;
          }
        }
        count++;
      }
      return count;
    }

    public int solution( int n, int[][] wires ) {
      int answer = Integer.MAX_VALUE;
      int num1   = 0;
      int num2   = 0;

      for( int i = 0; i < wires.length; i++ ) {
        num1 = getBfsNum( i, wires );
        num2 = n - num1;
        int temp = Math.abs( num1 - num2 );
        answer = Math.min( temp, answer );
      }
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
    System.out.println( "RESULT = " + solution.solution( n2, wires2 ) );
  }
}
