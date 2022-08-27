package lv2;

import java.util.Stack;

public class GwalHoCheck {
  public static class Solution {
    public boolean solution( String s ) {
      boolean answer = true;

      Stack<Character> stack = new Stack<>();

      for (int i = 0; i < s.length(); i++) {
        Character ch = s.charAt(i);

        if( i == 0 && ch == ')' ) {
          answer = false;
          break;
        }

        if( ch == '(' ) {
          stack.push( ch );
        } else if( ch == ')' ){
          if( !stack.isEmpty() ) {
            stack.pop();
          }
        }
      }

      if( stack.size() != 0 ) {
        answer = false;
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s    = "()()";
    String ss   = "(())()";
    String sss  = ")()(";
    String ssss = "(()(";

    boolean result = solution.solution( s );
    System.out.println( "RESULT = " + result );
  }
}
