package lv2;

import java.util.Stack;

//짝지어 제거하기
public class CoupleDelete {
  public static class Solution {
    public int solution( String s ) {
      int answer = -1;

      Stack<Character> stack = new Stack<>();

      for( int i = 0; i < s.length(); i++ ) {
        char ch = s.charAt( i );
        if( !stack.isEmpty() && stack.peek() == ch ) {
          stack.pop();
        } else {
          stack.push( ch );
        }
      }

//      while( true ) {
//        boolean flag = false;
//        if( s.equals( "" ) ) {
//          answer = 1;
//          break;
//        }
//        for( int i = 0; i < s.length() - 1; i++ ) {
//          Character ch1 = s.charAt( i );
//          Character ch2 = s.charAt( i + 1);
//
//          if( ch1 == ch2 ) {
//            s = s.substring( 0, i ) + '?' + s.substring( i + 1 );
//            s = s.substring( 0, i + 1 ) + '?' + s.substring( i + 2 );
//            flag = true;
//            break;
//          }
//        }
//
//        if( flag == false ) {
//          answer = 0;
//          break;
//        }
//        s = s.replace( "??", "" );
//      }

      return ( stack.size() == 0 ) ? 1 : 0;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "baabaa";
    String ss = "cdcd";

    int result = solution.solution( s );  // 1   ss -> 0
    System.out.println( "RESULT = " + result );
  }
}
