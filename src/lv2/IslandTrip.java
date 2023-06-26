package lv2;
//무인드 여행
public class IslandTrip {
  public static class Solution {
    public static int[][] distance = { {-1,0}, {1,0}, {0,-1}, {0,1} };
    static String[][] Map = {};

    public int[] dfs( int[] answer ) {

      return answer;
    }

    public int[] solution(String[] maps) {
      int[] answer = {};

      Map = new String[maps.length][maps[0].length()];

      for( int i = 0; i < maps.length; i++ ) {
        String temp = maps[i];
        for( int j = 0; j < temp.length(); j++ ) {
          Character ch = temp.charAt( j );
          Map[i][j] = String.valueOf( ch );
        }
      }



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
