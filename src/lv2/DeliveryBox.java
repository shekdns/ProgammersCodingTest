package lv2;

import java.util.Stack;

//택배 상자
public class DeliveryBox {
  public static class Solution {
    public int solution( int[] order ) {
      int answer = 0;

      Stack<Integer> Box = new Stack<>();

      int i = 0;
      int j = 0;
      while( i < order.length ) {
        Box.push( i + 1) ;

        while( !Box.isEmpty() ) {
          int item = Box.peek();
          if( item == order[j] ) {
            j++;
            Box.pop();
            answer++;
          } else {
            break;
          }
        }
        i++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] order = { 5,4,3,2,1 };
    int result = solution.solution( order );
    System.out.println( "RESULT = " + result );
  }
}
