package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

//연속 부분 수열 합의 개수
public class NumbericalSum {
  public static class Solution {
    public int solution( int[] elements ) {
      int answer = 0;

      HashSet<Integer> hashSet = new HashSet<>();
      List<Integer> list = Arrays.stream( elements ).boxed().collect(Collectors.toList());
      int t = list.remove(0 );
      System.out.println( t );
      System.out.println( list );
      list.add( list.size(), t );
      System.out.println( list );
//      int i = 0;
//      while( true ) {
//        if( i == elements.length - 1 ) {
//          break;
//        }
//        for( int j = 0; j < elements.length; j++ ) {
//          int sum = 0;
//          for( int k = 0; k < i + 1; k++ ) {
//
//          }
//        }
//      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] elements = { 7, 9, 1, 1, 4 };
    int result = solution.solution( elements );
    System.out.println( "RESULT = " + result );
  }
}
