package lv1.pcc;

import java.util.HashSet;

public class Park {
  public static class Solution {
    public int solution(int[] mats, String[][] park) {
      int[][]dp = new int[park.length][park[0].length];
      HashSet<Integer> numList = new HashSet<>();
      for( int i = 0; i < park.length; i++ ) {
        for( int j = 0; j < park[0].length; j++ ) {
          if( park[i][j].equals("-1") ) {
            dp[i][j] = 1;
          } else {
            dp[i][j] = 0;
          }
        }
      }
      for( int i = 1; i < dp.length; i++ ) {
        for( int j = 1; j < dp[0].length; j++ ) {
          if( dp[i][j] == 0 ) {
            continue;
          }

          System.out.println( "dp[" + i + "][" + j + "] = " + dp[i][j] );
          System.out.println( "dp[" + (i-1) + "][" + (j-1) + "] = " + dp[i-1][j-1] );
          System.out.println( "dp[" + (i) + "][" + (j-1) + "] = " + dp[i][j-1] );
          System.out.println( "dp[" + (i-1) + "][" + (j) + "] = " + dp[i-1][j] );
          System.out.println( "MIN = " + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) );
          dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
          int a = dp[i][j];
          System.out.println( "A = " + a );
          System.out.println( "=====================================================" );
          numList.add(dp[i][j]);
        }
      }

      int answer = -1;
      for(int su : mats){
        if(numList.contains(su)) {
          answer = Math.max(answer, su);
        }
      }

      System.out.println( "MAX = " + answer );

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] mats   = { 5, 3, 2 };
    String[][] park = { { "-1", "A", "-1", "B", "C", "F", "G", "-1" },
                        { "A", "-1", "-1", "B", "C", "F", "G", "-1" },
                        { "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" },
                        { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
                        {  "D", "D", "-1", "-1", "-1", "-1", "-1", "F" },
                        { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" } };

    System.out.println( "RESULT = " + solution.solution( mats, park ) );
  }
}
