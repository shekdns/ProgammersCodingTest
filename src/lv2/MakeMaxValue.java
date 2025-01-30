package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//큰 수 만들기
public class MakeMaxValue {
  public static class Solution {

    public String solution( String number, int k ) {
      String answer = "";

      List<Integer>  list = new ArrayList<>();
      for( int i = 0; i < number.length(); i++ ) {
        Character c = number.charAt(i);
        list.add ( Integer.parseInt( c.toString() ) );
      }

      Stack<Integer> stack = new Stack<>();
      stack.push( list.get( 0 ) );

      for( int i = 1; i < list.size(); i++ ) {
        while( true ) {
          int listVal = list.get( i );
          if( k == 0 ) {
            stack.push( listVal );
            break;
          }
          if( stack.isEmpty() ) {
            stack.push( list.get( i ) );
            break;
          }
          int temp    = stack.peek();
          if( temp >= listVal ) {
            stack.push( listVal );
            break;
          } else {
            stack.pop();
            k--;
          }
        }
      }

      StringBuilder sb =  new StringBuilder();
      while( !stack.isEmpty() ) {
        sb.append( stack.pop() );
      }

      sb.reverse();

      int maxLength = number.length() - k;
      if( maxLength < sb.toString().length() ) {
        sb = new StringBuilder( sb.substring(0, maxLength) );
      }

      answer = sb.toString();

      return answer;
    }
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    String number1 = "1924";
    String number2 = "1231234";
    String number3 = "4177252841";
    String number4 = "987654";

    int k1 = 2;
    int k2 = 3;
    int k3 = 4;
    int k4 = 2;

    System.out.println( "RESULT = " + solution.solution( number4, k4 ) );
  }
}
