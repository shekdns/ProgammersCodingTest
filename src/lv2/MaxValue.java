package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxValue {
  public static class Solution {
    public String solution( int[] numbers ) {
      String answer = "";

      List<Integer> list = new ArrayList<>();

      for( int number : numbers ) {
        list.add( number );
      }

      Comparator<Integer> comparator = (o1, o2) -> {
        Integer after = Integer.valueOf(o1.toString() + o2.toString());
        Integer before = Integer.valueOf(o2.toString() + o1.toString());

        return after.compareTo( before );
      };

      list.sort( comparator.reversed() );

      String sb = "";
      for( Integer i : list ) {
        sb += String.valueOf( i );
      }

      return sb.startsWith( "0" ) ? "0" : sb;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] numbers1 = { 6, 10, 2 };
    int[] numbers2 = { 3, 30, 34, 5, 9 };
    int[] numbers3 = { 1, 10 ,100, 1000 };
    int[] numbers4 = { 2, 20, 200 };
    int[] numbers5 = { 101, 10, 232, 23 };
    int[] numbers6 = { 40, 403 };

    String result = solution.solution( numbers6 );
    System.out.println( "RESULT = " + result );
  }
}
