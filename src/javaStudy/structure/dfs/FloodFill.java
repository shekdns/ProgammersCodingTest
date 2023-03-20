package javaStudy.structure.dfs;

import java.util.Scanner;
import java.util.Stack;

//FloodFill 알고리즘
public class FloodFill {
  static final int MAX_N = 10;
  static int[][] D = { {-1,0}, {1,0}, {0,-1}, {0,1} };
  static int N;
  static int[][] Board = new int[MAX_N][MAX_N];

  static class Point {
    int row, col;

    Point( int r, int c ) {
      this.row = r;
      this.col = c;
    }
  }

  public static void dfs( int r , int c , int color ) {
    boolean[][] visited = new boolean[MAX_N][MAX_N];
    Stack<Point> myStack = new Stack<>();
    myStack.push( new Point( r, c ) );

    while( !myStack.empty() ) {
      Point curr = myStack.pop();

      if( visited[curr.row][curr.col] ) {
        continue;
      }

      visited[curr.row][curr.col] = true;
      Board[curr.row][curr.col] = color;

      for( int i = 0; i < 4; i++ ) {
        int nr = curr.row + D[i][0];
        int nc = curr.col + D[i][1];

        if( nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1 ) { // 행열을 벗어나면 스킵
          continue;
        }
        if( visited[nr][nc] ) { // 방문한 위치
          continue;
        }
        if( Board[nr][nc] == 1 ) { // 벽
          continue;
        }
        myStack.push( new Point( nr, nc ) );
      }
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner( System.in );
    N = scan.nextInt();

    for( int i = 0; i < N; i++ ) {
      for( int j = 0; j < N; j++ ) {
        Board[i][j] = scan.nextInt();
      }
    }

    int sRow = scan.nextInt();
    int sCol = scan.nextInt();
    int color = scan.nextInt();
    dfs( sRow, sCol, color );

    for( int i = 0; i < N; i++ ) {
      for( int j = 0; j < N; j++ ) {
        System.out.print( Board[i][j] + " " );
      }
      System.out.println();
    }
  }
}
