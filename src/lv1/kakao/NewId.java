package lv1.kakao;
/*
*
1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
* */
//다른 사람 풀이중 정규식 참고
/*
*("[^a-z0-9._-]", "");
* ("[.]{2,}", ".");
* ("^[.]|[.]$", "");
* */

import java.util.Locale;
import java.util.regex.Pattern;

public class NewId {
  public static class Solution {
    public boolean isNumberCheck( Character ch ) {
      return Pattern.matches( "^[0-9]*$", ch.toString() );
    }

    public boolean isAbcCheck( Character ch ) {
      return Pattern.matches( "^[a-z]*$", ch.toString() );
    }

    public boolean isSpeCheck( Character ch ) {
      boolean flag = false;
      String str = ch.toString();
      if( str.equals( "-" ) || str.equals( "_" ) || str.equals( "." ) ) {
        flag = true;
      }

      return flag;
    }

    public String solution(String new_id) {
      String answer = new_id;
      //step1
      answer = answer.toLowerCase(Locale.ROOT);

      //step2
      for( int i = 0; i < answer.length(); i++ ) {
        Character ch = answer.charAt( i );

        if( !isNumberCheck( ch ) ) {
          if( !isAbcCheck( ch ) ) {
            if( !isSpeCheck( ch ) ) {
              answer = answer.replace( ch.toString(), "" );
              i--;
            }
          }
        }
      }
      System.out.println( "step 2 = " + answer );
      //step3
      int count = 0;
      while ( answer.contains("..") ) {
        answer = answer.replace("..", ".");
      }
//      StringBuilder sb = new StringBuilder();
//      for( int i = 0; i < answer.length(); i++ ) {
//        Character ch = answer.charAt( i );
//        if( ch.toString().equals( "." ) ) {
//          count++;
//          sb.append( ch );
//
//          if( i == answer.length() - 1 ) {
//            if( count > 1 ) {
//              answer = answer.replace( sb.toString(), "." );
//            }
//          }
//        } else {
//          if( count > 1 ) {
//            answer = answer.replace( sb.toString(), "." );
//            i--;
//            sb.setLength(0);
//          }
//          sb.setLength(0);
//          count = 0;
//        }
//      }
      System.out.println( "step 3 = " + answer );
      //step4
      String first = "";
      String last  = "";
      if( !answer.isEmpty() ) {
        first = String.valueOf( answer.charAt(0) );
        last  = String.valueOf( answer.charAt( answer.length() - 1 ) );
      }
      if( first.equals( "." ) ) {
        answer = answer.substring(1 );
      }
      if( last.equals( "." ) ) {
        if( !answer.isEmpty() ) {
          answer = answer.substring( 0, answer.length() - 1 );
        }
      }

      System.out.println( "step 4 = " + answer );
      //step5
      if( answer.isEmpty() ) {
        answer = "a";
      }
      System.out.println( "step 5 = " + answer );
      //step6
      if( answer.length() > 15 ) {
        answer = answer.substring( 0, 15 );
        String last2 = String.valueOf( answer.charAt( answer.length() - 1 ) );
        if( last2.equals( "." ) ) {
          answer = answer.substring( 0, answer.length() - 1 );
        }
      }
      System.out.println( "step 6 = " + answer );

      //step7
      if( answer.length() <= 2 ) {
        String last3 = String.valueOf( answer.charAt( answer.length() - 1 ) );
        for( int i = answer.length(); i < 3; i++ ) {
          answer += last3;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String id1 = "...!@BaT#*..y.abcdefghijklm";
    String id2 = "=.=";
    String id3 = "z-+.^.";
    String id4 = ".abcd.45353453447634eeee.";

    //System.out.println( "RESULT = " + solution.solution( id1 ) );
    //System.out.println( "RESULT = " + solution.solution( id2 ) );
    //System.out.println( "RESULT = " + solution.solution( id3 ) );
    System.out.println( "RESULT = " + solution.solution( id4 ) );

    //3 12 21 25
  }
}
