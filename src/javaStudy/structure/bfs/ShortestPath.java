package javaStudy.structure.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//최단거리
public class ShortestPath {
  static final int MAX_N = 10;
  static int[][] D = { {-1,0}, {1,0}, {0,-1}, {0,1} };
  static int N;
  static int[][] Board = new int[MAX_N][MAX_N];

  static class Point {
    int row;
    int col;
    int dist;

    Point( int r, int c, int d ) {
      this.row  = r;
      this.col  = c;
      this.dist = d;
    }
  }

  static int bfs( int sRow, int sCol, int dRow, int dCol ) {
    boolean[][] visited = new boolean[MAX_N][MAX_N];
    Queue<Point> queue = new LinkedList<>();
    visited[sRow][sCol] = true;
    queue.add( new Point( sRow, sCol, 0 + 1 ) );

    while( !queue.isEmpty() ) {
      Point curr = queue.remove();
      System.out.println( "REMOVE CURR ROW = " + curr.row + " COL = " + curr.col + " DIST = " + curr.dist );
      if( curr.row == dRow && curr.col == dCol ) {
        return curr.dist;
      }

      for( int i = 0; i < 4; i++ ) {
        int nr = curr.row + D[i][0];
        int nc = curr.col + D[i][1];

        if( nr < 0 || nr > N-1 || nc < 0 || nc > N-1 ) {
          continue;
        }
        if( visited[nr][nc] == true ) {
          System.out.println( "VISITED[NR][NC] == TRUE " + "  NR = " + nr + "  NC = " + nc );
          continue;
        }
        if( Board[nr][nc] == 1 ) {
          continue;
        }
        visited[nr][nc] = true;
        queue.add( new Point( nr, nc, curr.dist + 1 ) );
        System.out.println( "NR = " + nr + "  NC = " + nc + " DI = " + curr.dist );
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner( System.in );
    N = scan.nextInt();

    for( int i = 0; i < N; i++ ) {
      for( int j = 0; j < N; j++ ) {
        Board[i][j] = scan.nextInt();
      }
    }

    int sRow, sCol, dRow, dCol;
    sRow = scan.nextInt();
    sCol = scan.nextInt();
    dRow = scan.nextInt();
    dCol = scan.nextInt();
    System.out.println( bfs( sRow, sCol, dRow, dCol ) );
  }
}
