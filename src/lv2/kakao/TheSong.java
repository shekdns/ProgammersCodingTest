package lv2.kakao;

import java.util.Stack;

//방금그곡
public class TheSong {
  public static class Solution{
    public String solution( String m, String[] musicinfos ) {
      String answer = "";

      Stack<String> stack = new Stack<>();
      /*
      1. 시작 시간 부터 종료 시간 까지 1분당 멜로디가 1개식 추가
      2. 시작 멜로디는 melodie 멜로디 부터 시작
      3.
       */
      for( int i = 0; i < musicinfos.length; i++ ) {
        String[] split = musicinfos[i].split( "," );
        String startTime = split[0].replace( ":", "" );
        String endTime   = split[1].replace( ":", "" );
        String title     = split[2];
        String melodie   = split[3];
        int melodieSize  = melodie.length();
        int dir = Integer.parseInt( startTime ) - Integer.parseInt( endTime );

        String fullMelodie = melodie + m;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    String m = "ABCDEFG";
    String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    Solution solution = new Solution();

    /*

     */
    System.out.println( "RESULT = " + solution.solution( m, musicinfos ) );
  }
}
