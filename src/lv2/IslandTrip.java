package lv2;

import java.util.ArrayList;
import java.util.Stack;

//무인드 여행
public class IslandTrip {
  public static class Solution {
    public static int[][] distance = { {-1,0}, {1,0}, {0,-1}, {0,1} };
    static String[][] Map = {};

    static class Point {
      int row;
      int col;

      Point( int r, int c ) {
        this.row = r;
        this.col = c;
      }
    }

    public int[] dfs( int rowSize, int colSize ) {
      boolean[][] visited = new boolean[rowSize][colSize];
      ArrayList<Integer> arrayList = new ArrayList<>();
      int[] returnArray = {};
      Stack<Point> stack = new Stack<>();
      stack.push( new Point( 0, 0 ) );

      while( !stack.empty() ) {
        Point curr = stack.pop();
        if( visited[curr.row][curr.col] == true ) {
          continue;
        }
        if( Map[curr.row][curr.col].equals( "X" ) ) {
          continue;
        }
        visited[curr.row][curr.col] = true;


      }

      return returnArray;
    }

    public int[] solution(String[] maps) {
      int[] answer = {};

      int rowSize = maps.length;
      int colSize = maps[0].length();

      Map = new String[rowSize][colSize];

      for( int i = 0; i < maps.length; i++ ) {
        String temp = maps[i];
        for( int j = 0; j < temp.length(); j++ ) {
          Character ch = temp.charAt( j );
          Map[i][j] = String.valueOf( ch );
        }
      }

      answer = dfs( rowSize, colSize );

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
