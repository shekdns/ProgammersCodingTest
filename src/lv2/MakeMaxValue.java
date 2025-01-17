package lv2;

import java.util.ArrayList;
import java.util.HashMap;
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
      int maxLength = number.length() - k - 1;
      int count = 0;






      return answer;
    }

    public String solution_back( String number, int k ) {
      String answer = "";

      String front = number.substring( 0, number.length() - k  );
      String back  = number.substring( number.length() - k  );

      int tempMax = Integer.MIN_VALUE;
      Stack<String> stack = new Stack<>();

      if( front.length() == back.length() ) {
        for (int i = 0; i < front.length(); i++) {
          Character ch = front.charAt(i);
          int temp = Integer.parseInt(ch.toString());

          if (temp > tempMax) {
            tempMax = temp;
          }
        }

        stack.add( String.valueOf( tempMax ) );
        int limitSize = number.length() - k;

        for( int i = 0; i < back.length(); i++ ) {
          Character ch = back.charAt( i );
          int temp = Integer.parseInt( ch.toString() );
          int bVal = Integer.parseInt( stack.peek() );

          if( i == 0 ) {
            if( bVal < temp ) {
              stack.pop();
              stack.add( String.valueOf( temp ) );
            } else {
              stack.add( String.valueOf( temp ) );
            }
          } else {
            if( bVal < temp ) {
              stack.pop();
              stack.add( String.valueOf( temp ) );
            } else {
              if( stack.size() < limitSize ) {
                stack.add( String.valueOf( temp ) );
              }
            }
          }
        }
      } else {
        System.out.println( "F = " + front + " || B = " + back );
      }

      StringBuilder sb = new StringBuilder();
      for( String s : stack ) {
        sb.append( s );
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

    int k1 = 2;
    int k2 = 3;
    int k3 = 4;

    System.out.println( "RESULT = " + solution.solution( number3, k3 ) );
  }
}
