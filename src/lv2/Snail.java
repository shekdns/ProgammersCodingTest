package lv2;

public class Snail {
  public static class Solution {
    public int[] solution( int n ) {
      int[] answer;
      int[][] temp = new int[n][n];
      int num = 1;
      int x   = -1;
      int y   = 0;

      int len = 0;
      for( int i = n; i >= 1; i-- ) {
        len += i;
      }
      answer = new int[len];

      for( int i = 0; i < n; i++ ) {
        System.out.println( "I = " + i );
        for( int j = i; j < n; j++ ) {
          if( i % 3 == 0 ) {
            System.out.println( "i % 3 == 0 : " + i % 3 );
            x++;
          } else if( i % 3 == 1 ) {
            System.out.println( "i % 3 == 1 : " + i % 3 );
            y++;
          } else if( i% 3 == 2 ) {
            System.out.println( "i % 3 == 2 : " + i % 3 );
            x--;
            y--;
          }
          temp[x][y] = num++;
          System.out.println( "NUM = " + num );
        }
      }
      int v = 0;
      for( int i = 0; i < n; i++ ) {
        for( int j = 0; j < n; j++ ) {
          if( temp[i][j] == 0 ) {
            break;
          }
          answer[v++] = temp[i][j];
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 4;

    int[] result = solution.solution( n );

    for( int v : result ) {
      System.out.print( v + " " );
    }
  }
}
