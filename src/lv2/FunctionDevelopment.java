package lv2;

import java.util.ArrayList;
import java.util.Stack;

public class FunctionDevelopment {
  public static class Solution {
    public int[] solution( int[] progresses, int[] speeds ) {
      int[] answer = {};
      int batch = 100;

      ArrayList<Integer> arraylist = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();
      for( int i = 0; i < progresses.length; i++ ) {
        int time = batch - progresses[i];

        int mok = time / speeds[i];
        int na  = time % speeds[i];
        if( na != 0 ) {
          mok += 1;
        }
        arraylist.add( mok );
      }
      System.out.println( arraylist );
      int value = 0;
      ArrayList<Integer> tempList = new ArrayList<>();
      stack.push(arraylist.get(0) );
      for( int array : arraylist ) {
        if( )
//        if( count == 0 ) {
//          stack.push( array );
//          value++;
//        } else {
//          if( !stack.isEmpty() ) {
//            int temp = stack.peek();
//            System.out.println( "TEMP = " + temp + "  ARRAY = " + array );
//            System.out.println( "VAL  = " + value );
//            if( temp < array ) {
//              tempList.add( value );
//              value = 0;
//              stack.pop();
//              stack.push( array );
//            } else {
//              value++;
//              System.out.println( "TEMP 가 크다 " );
//            }
//          }
//        }
      }

      System.out.println( tempList );

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] progresses = { 93, 30, 55 };
    //int[] progresses = { 95, 90, 99, 99, 80, 99 };
    int[] speeds     = { 1, 30, 5 };
    //int[] speeds     = { 1, 1, 1, 1, 1, 1 };

    int[] result = solution.solution( progresses, speeds );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
