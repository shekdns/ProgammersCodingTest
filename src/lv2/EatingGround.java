package lv2;
//땅따먹기
public class EatingGround {
  public static int max( int a, int b, int c ) {
    return Math.max( Math.max( a, b ), c );
  }

  public static int max( int[] array ) {
    int max = 0;
    for( int number : array ) {
      max = Math.max( max, number );
    }
    return max;
  }

  public static class Solution {
    int solution( int[][] land ) {
      int answer = 0;

      //int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
      // 1 2 3 5
      // 5 6 7 8
      // 4 3 2 1

      for( int i = 1; i < land.length; i++ ) {
        land[i][0] += max( land[i-1][1], land[i-1][2], land[i-1][3] );
        System.out.println( "I = " + i + "  10 = " + land[i][0] );
        land[i][1] += max( land[i-1][0], land[i-1][2], land[i-1][3] );
        System.out.println( "I = " + i + "  11 = " + land[i][1] );
        land[i][2] += max( land[i-1][1], land[i-1][3], land[i-1][0] );
        System.out.println( "I = " + i + "  12 = " + land[i][2] );
        land[i][3] += max( land[i-1][1], land[i-1][2], land[i-1][0] );
        System.out.println( "I = " + i + "  13 = " + land[i][3] );
      }

//      int[] temp = new int[land.length];
//      int[] d = new int[land.length];
//
//      int dir = 0;
//      for( int i = 0; i < land.length; i++ ) {
//        int max = land[i][0];
//        for( int j = 0; j < land[i].length; j++ ) {
//          if( i == 0 ) {
//            if( max < land[i][j] ) {
//              max = land[i][j];
//              dir = j;
//            }
//          } else if( i != 0 ) {
//            if( d[i - 1] != j ){
//              if( max < land[i][j] ) {
//                max = land[i][j];
//                dir = j;
//              }
//            }
//          }
//        }
//        d[i]    = dir;
//        temp[i] = max;
//      }
//
//      for( int v : temp ) {
//        answer += v;
//      }
      //dp로 다시 풀기

      answer = max( land[land.length - 1] );

      return answer;
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
//    int[][] land = { { 4, 3, 2, 1 }, { 2, 2, 2, 1 }, { 6, 6, 6, 4 }, { 8, 7, 6, 5 } };

    int result = solution.solution( land );
    System.out.println( "RESULT = " + result );
  }
}
