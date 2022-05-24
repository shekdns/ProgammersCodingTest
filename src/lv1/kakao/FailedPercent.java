package lv1.kakao;

import java.util.*;

public class FailedPercent {
  public static class Solution {
    public int[] solution( int N, int[] stages ) {
      int[] answer;
      int count = 0;
      int challenger = stages.length;
      double percent = 0;
      LinkedHashMap<Integer, Double> map = new LinkedHashMap<Integer, Double>();

      for( int i = 1; i <= N; i++ ) {
        for( int j = 0; j < stages.length; j++ ) {
          if( i == stages[j] ) {
            count++;
          }
        }
        if( count == 0 ) {
          percent = 0;
        } else {
          percent = (double) count / (double) challenger * 100.0;
          challenger -= count;
        }
        count = 0;
        map.put( i, percent );
      }

      answer = new int[map.size()];

      int k = 0;
      List<Map.Entry<Integer, Double>> entryList = new LinkedList<>( map.entrySet() );
      entryList.sort( Map.Entry.comparingByValue( Comparator.reverseOrder() ) );
      for( Map.Entry<Integer, Double> entry : entryList ) {
        answer[k] = entry.getKey();
        k++;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int N = 5;
    int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };

    int[] result = solution.solution( N, stages );

    for( int r : result ) {
      System.out.print( r + " " );
    }

  }
}
