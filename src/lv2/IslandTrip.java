package lv2;
//무인드 여행
public class IslandTrip {
  public static class Solution {
    public int[] solution(String[] maps) {
      int[] answer = {};
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] map1 = { "X591X","X1X5X","X231X", "1XXX1" };
    String[] map2 = { "XXX","XXX","XXX" };

    int[] result = solution.solution( map1 );

    for( int i : result ) {
      System.out.print( i + " " );
    }
    System.out.println();
  }
}
