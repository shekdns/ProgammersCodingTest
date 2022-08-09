package lv2;

import java.util.Stack;

public class GwalHoChange {
  public static String shift( String s ) {
    return s.charAt( s.length() - 1 ) + s.substring( 0, s.length() - 1 );
  }

  public static class Solution {
    public int solution( String s ) {
      int answer = 0;
      int s_length = s.length();

      for( int i = 0; i < s_length; i++ ) {
        s = shift( s );
        System.out.println( "SSSSSS = " + s );
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        if( s.length() % 2 == 0 ) {
          for (int j = 0; j < s.length(); j++) {
            Character ch = s.charAt(j);
            if (String.valueOf(ch).equals("(") || String.valueOf(ch).equals("[") || String.valueOf(ch).equals("{")) {
              stack.push(ch);
            } else {
              if (!stack.isEmpty()) {
                Character c = stack.pop();
                System.out.println("C = " + c);
                System.out.println("CH = " + ch);
                if (c == '(' && ch == ')') {
                  continue;
                } else if (c == '{' && ch == '}') {
                  continue;
                } else if (c == '[' && ch == ']') {
                  continue;
                } else {
                  flag = false;
                  continue;
                }
              } else {
                flag = false;
                continue;
              }
            }
          }
        } else {
          flag = false;
        }
        if( flag == true ) {
          answer++;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "[](){}";
    String ss = "}]()[{";
    String sss = "[)(]";
    String s131 = "()(";
    String s132 = "(";
    String s133 = "{{{{{{";

    int reuslt = solution.solution( s133 );

    System.out.println( "RESULT = " + reuslt );

  }
}
