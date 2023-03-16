package lv2;

//게임 맵 최단거리
public class GameMapDistance {
  public static class Solution {
    public int solution( int[][] maps ) {
      int answer = 0;

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] maps = { { 1,0,1,1,1 }, { 1,0,1,0,1 }, { 1,0,1,1,1 }, { 1,1,1,0,1 }, { 0,0,0,0,1 } };
    int result = solution.solution( maps );

    System.out.println( "RESULT = " + result );
  }
}
