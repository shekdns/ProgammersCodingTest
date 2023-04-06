package lv2;
//모음사전
public class VowelDictionary {
  public static class Solution {
    public int solution( String world ) {
      int answer = 0;
      String array[] = { "A", "E", "I", "O", "U" };

      int wordCount = 0;
      while( true ) {
        String temp = "";



        if( temp.equals( world ) || temp.equals( "UUUUU" ) ) {
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String word = "AAAAE";
    int result  = solution.solution( word );
    System.out.println( "RESULT = " + result );
  }
}
