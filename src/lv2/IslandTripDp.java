package lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IslandTripDp {
  public static class Solution {
    static boolean[][] dps = null;
    String[][] map = null;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public void dfs( int x, int y) {
      if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || dps[x][y] || map[x][y].equals("X" ) ) {
        return;
      }
      count += Integer.parseInt( map[x][y] );
      dps[x][y] = true; // 방문 처리
      for( int i = 0; i < 4; i++ ) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        dfs(nx, ny);
      }
    }

    public int[] solution(String[] maps) {
      int[] answer = {};
      dps = new boolean[maps.length][maps[0].length()];
      map = new String[maps.length][maps[0].length()];
      for( int i = 0; i < maps.length; i++ ) {
        String str = maps[i];
        for( int j = 0; j < str.length(); j++ ) {
          char ch = str.charAt(j);
          map[i][j] = Character.toString(ch);
        }
      }

      for( int i = 0; i < map.length; i++ ) {
        for( int j = 0; j < map[0].length; j++ ) {
          if( !dps[i][j] && !map[i][j].equals("X") ) {
            dfs(i, j);
            list.add( count );
            count = 0;
          }
        }
      }

      if( list.isEmpty() ) {
        answer = new int[1];
        answer[0] = -1;
      } else {
        Collections.sort( list );
        answer = list.stream().mapToInt(Integer::intValue).toArray();
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    IslandTripDp.Solution solution = new IslandTripDp.Solution();
    String[] map1 = { "X591X","X1X5X","X231X", "1XXX1" };
    String[] map2 = { "XXX","XXX","XXX" };

    int[] result = solution.solution( map2 );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
