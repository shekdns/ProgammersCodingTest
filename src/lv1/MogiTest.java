package lv1;

import java.util.ArrayList;
import java.util.List;

public class MogiTest {
  public static class Solution {
    public int[] solution( int[] answers ) {
      int[][] student = {
              { 1, 2, 3, 4, 5 },
              { 2, 1, 2, 3, 2, 4, 2, 5 },
              { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
      };
      int[] count = { 0, 0, 0 };
      int k = 0;

      for( int i = 0; i < student.length; i++ ) {
        for( int j = 0; j < answers.length; j++ ) {
          if( j % student[i].length == 0 ) {   //K를 내부에서 초기화 할려고
            k = 0;
          }
          if( answers[j] == student[i][k] ) {
            count[i]++;
          }
          k++;
        }
        k = 0;
      }

      int[] answer;
      int   max = 0;
      int   p   = 0;

      List<Integer> list = new ArrayList<Integer>();

      for( int i = 0; i < count.length; i++) {
        if( max < count[i] ) {
          max = count[i];
        }
      }

      for( int i = 0; i < count.length; i++ ) {
        p++;
        if( max == count[i] ) {
          list.add( p );
        }
      }

      answer = new int[list.size()];
      int kk = 0;
      for( int pp : list ) {
        answer[kk] = pp;
        kk++;
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answers = { 1, 2, 3, 4, 5 };
    int[] result = solution.solution( answers );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
