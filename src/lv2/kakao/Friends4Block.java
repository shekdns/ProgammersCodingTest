package lv2.kakao;

public class Friends4Block {

  public static class Solution {
    public int solution( int m, int n, String[] board ) {
      int answer = 0;

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int m = 4;
    int n = 5;
    String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
    int result = solution.solution( m, n, board );
    System.out.println( "RESULT = " + result );
  }
}
