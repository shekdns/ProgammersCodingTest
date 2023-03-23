package lv2;


import java.util.LinkedList;
import java.util.Queue;

//게임 맵 최단거리
public class GameMapDistance {
  public static class Solution {
    public static int[][] board = {};
    public static int[][] D = { {-1,0}, {1,0}, {0,-1}, {0,1} };
    public static class Point {
      int row;
      int col;
      int dist;
      Point( int r, int c, int d ) {
        this.row  = r;
        this.col  = c;
        this.dist = d;
      }
    }

    public static int bfs( int startRow, int startCol, int endRow, int endCol ) {
      boolean[][] visited = new boolean[endRow][endCol];
      Queue<Point> queue = new LinkedList<>();
      visited[startRow][startCol] = true;
      queue.add( new Point( startRow, startCol, 0 + 1 ) );

      while( !queue.isEmpty() ) {
        Point curr = queue.remove();
        System.out.println( curr.row + " | " + curr.col + " | " + curr.dist );
        if( curr.row == endRow - 1 && curr.col == endCol - 1 ) {
          return curr.dist;
        }

        for( int i = 0; i < 4; i++ ) {
          int nr = curr.row + D[i][0];
          int nc = curr.col + D[i][1];

          if( nr < 0 || nr > endRow - 1 || nc < 0 || nc > endCol - 1 ) {
            continue;
          }
          if( visited[nr][nc] == true ) {
            continue;
          }
          if( board[nr][nc] == 0 ) {
            continue;
          }
          visited[nr][nc] = true;
          queue.add( new Point( nr, nc, curr.dist + 1 ) );
        }
      }

      return -1;
    }
    public int solution( int[][] maps ) {
      int answer = 0;
      int startRow = 0;
      int startCol = 0;
      int endRow   = maps.length;
      int endCol   = maps[0].length;
      board = maps;

      System.out.println( endRow + " | " + endCol );

      answer = bfs( startRow, startCol, endRow, endCol );

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
