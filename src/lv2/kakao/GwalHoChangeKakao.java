package lv2.kakao;

//2020 KAKAO BLIND RECRUITMNET 괄호 변환
public class GwalHoChangeKakao {

  public static class Solution {

    public String changeGwal( String p ) {
      String u = "";
      String v = "";
      int count = 0;

      if( p.equals( "" ) ) {
        return "";
      }
      boolean flag = true;
      for( int i = 0; i < p.length(); i++ ) {
        String temp = String.valueOf( p.charAt( i ) );
        if( temp.equals( "(" ) ) {
          count++;
        } else {
          count--;
        }

        u += temp;

        if( count == 0 ) {
          if( !temp.equals( ")" ) ) {
            flag = false;
          }
          break;
        }
      }

      v = p.substring( u.length() );

      if( flag == true ) {
        return u + changeGwal( v );
      } else {
        String t  = u.substring( 1, u.length() - 1 );
        String tt = "";

        if( t.length() > 0 ) {
          for( int i = 0; i < t.length(); i++ ) {
            String s = String.valueOf( t.charAt( i ) );
            if( s.equals( "(" ) ) {
              tt += ")";
            } else {
              tt += "(";
            }
          }
        }
        return "(" + changeGwal( v ) + ")" + tt;
      }
    }

    public String solution( String p ) {
      String answer = "";

      answer = changeGwal( p );

      return answer;
    }
  }

  public static void main(String[] args) {
    /*
    1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
    3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
    3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
    4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
    4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
    4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
    4-3. ')'를 다시 붙입니다.
    4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
    4-5. 생성된 문자열을 반환합니다.

    p는 '(' 와 ')' 로만 이루어진 문자열이며 길이는 2 이상 1,000 이하인 짝수입니다.
    문자열 p를 이루는 '(' 와 ')' 의 개수는 항상 같습니다.
    만약 p가 이미 "올바른 괄호 문자열"이라면 그대로 return 하면 됩니다.
    */

    Solution solution = new Solution();
    String p1 = "(()())()";
    String p2 = ")(";   // ()
    String p3 = "()))((()"; // ()(())()

    System.out.println( solution.solution( p3 ) );
  }
}
