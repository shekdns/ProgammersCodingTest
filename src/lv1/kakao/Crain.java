package lv1.kakao;

import java.util.ArrayList;
import java.util.List;

public class Crain {
  public static class Solution {
    public int solution( int[][]board, int[] moves ) {
      int answer = 0;
      List<Integer> list = new ArrayList<Integer>();

      for( int i = 0; i < moves.length; i++ ) {
        int d = moves[i] - 1;
        for( int j = 0; j < board.length; j++ ) {
          if( board[j][d] != 0 ) {
            list.add( board[j][d] );
            board[j][d] = 0;
            break;
          }
        }
      }

      for( int i = 0; i < list.size() - 1; i++ ) {
        if( list.get( i ) == list.get( i + 1 ) ) {
          list.remove( i + 1 );
          list.remove( i );
          answer += 2;
          i = -1;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] board = { {0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1} };
    int[] moves = { 1,5,3,5,1,2,1,4 };

    int result = solution.solution( board, moves );

    System.out.println( "RESULT = " + result );

  }
}
