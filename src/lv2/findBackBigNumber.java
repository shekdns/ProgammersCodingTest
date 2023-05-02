package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//뒤에 있는 큰 수 찾기
public class findBackBigNumber {
  public static class Solution {
    public int[] solution( int[] numbers ) {
      int[] answer = new int[numbers.length];
      //ArrayList<Integer> list = new ArrayList<>();
//      int max = Arrays.stream( numbers ).max().getAsInt();
//      for( int i = 0; i < numbers.length; i++ ) {
//        if( i == numbers.length - 1 || numbers[i] >= max ) {
//          answer[i] = -1;
//        } else {
//          int temp = numbers[i];
//          boolean flag = false;
//          for( int j = i + 1; j < numbers.length; j++ ) {
//            if( temp < numbers[j] ) {
//              answer[i] = numbers[j];
//              flag = true;
//              break;
//            }
//          }
//          if( flag == false ) {
//            answer[i] = -1;
//          }
//        }
//      }
      //answer = list.stream().mapToInt( Integer::intValue ).toArray();
      ArrayList<Integer> list = new ArrayList<>();
      Stack<Integer> stack = new Stack<>();
//      for( int i = numbers.length - 1; i >= 0; i-- ) {
//        stack.push( numbers[i] );
//      }
      //stack.push( numbers[0] );
      for( int i = 0; i < numbers.length; i++ ) {
        if( i == 0 ) {
          stack.push( numbers[i] );
          continue;
        }
        while( !stack.isEmpty() ) {
          int peek = stack.peek();
          if( peek < numbers[i] ) {
            stack.pop();

          }
        }
      }

//      while( !stack.isEmpty() ) {
//        int peek = stack.peek();
//        boolean flag = false;
//        for( int j = i; j < numbers.length; j++ ) {
//          if( peek < numbers[j] ) {
//            //list.add( numbers[j] );
//            answer[count] = numbers[j];
//            if( i < numbers.length - 1 ) {
//              i++;
//            }
//            stack.pop();
//            flag = true;
//            break;
//          }
//        }
//        if( flag == false ) {
//          //list.add( -1 );
//          answer[count] = -1;
//          stack.pop();
//          if( i < numbers.length - 1 ) {
//            i++;
//          }
//        }
//        count++;
//      }

      //answer = list.stream().mapToInt( Integer::intValue ).toArray();

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] numbers1 = { 2, 3, 3, 5 };
    int[] numbers2 = { 9, 1, 5, 3, 6, 2 };

    int[] result = solution.solution( numbers1 );
    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
