package lv2.kakao;
//방금그곡
public class TheSong {
  public static class Solution{
    public String solution( String m, String[] musicinfos ) {
      String answer = "";

      return answer;
    }
  }

  public static void main(String[] args) {
    String m = "ABCDEFG";
    String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
    Solution solution = new Solution();

    System.out.println( "RESULT = " + solution.solution( m, musicinfos ) );
  }
}
