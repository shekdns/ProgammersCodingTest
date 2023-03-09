package lv2.kakao;

import java.util.ArrayList;

public class Friends4Block {

  public static class Solution {
    public int solution( int m, int n, String[] board ) {
      int answer = 0;

      String[][] array = new String[m][n];
      String[][] visit = new String[m][n];

      for( int i = 0; i < m; i++ ) {
        for( int j = 0; j < n; j++ ) {
          Character ch = board[i].charAt( j );
          array[i][j]  = String.valueOf( ch );
          visit[i][j]  = "@";
        }
      }

      while( true ) {
        boolean flag = false;

        for( int x = 0; x < m - 1; x++ ) {
          for( int y = 0; y < n - 1; y++ ) {
            if( array[x][y].equals( array[x][y+1] ) && array[x][y].equals( array[x+1][y] ) && array[x][y].equals( array[x+1][y+1] ) && !array[x][y].equals( "#" ) ) {
              visit[x][y]     = "#";
              visit[x][y+1]   = "#";
              visit[x+1][y]   = "#";
              visit[x+1][y+1] = "#";

              flag = true;
            }
          }
        }
        System.out.println( "FLAG = " + flag );
        for( int x = 0; x < m; x++ ) {
          for( int y = 0; y < n; y++ ) {
            if( visit[x][y].equals( "#" ) ) {
              answer++;
              array[x][y] = "#";
              visit[x][y] = "@";
            }
          }
        }

        for( int y = 0; y < n; y++ ) {
          ArrayList<String> temp = new ArrayList<>();
          for( int x = m - 1; x >= 0; x-- ) {
            if( !array[x][y].equals( "#" ) ) {
              temp.add( array[x][y] );
              array[x][y] = "#";
            }
          }

          for( int z = 0; z < temp.size(); z++ ) {
            array[m - 1 - z][y] = temp.get( z );
          }
        }
        if( flag == false ) {
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int m = 4;
    int n = 5;
    String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

    int x = 6;
    int y = 6;
    String[] board2 = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

    int result = solution.solution( x, y, board2 );
    System.out.println( "RESULT = " + result );
  }
}
