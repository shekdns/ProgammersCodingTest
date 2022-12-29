package lv2;

import java.util.*;

// 귤 고르기
public class SelectTangerine {

  public static class Solution {
    public int solution( int k, int[] tangerine ) {
      int answer = 0;

      HashMap<Integer, Integer> map = new HashMap<>();

      for( int i = 0; i < tangerine.length; i++ ) {
        map.put( tangerine[i], map.getOrDefault( tangerine[i], 0 ) + 1 );
      }

      List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>( map.entrySet() );
      entryList.sort( new Comparator<Map.Entry<Integer, Integer>>() {
        @Override
        public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
          return o2.getValue() - o1.getValue();
        }
      });

      for( Map.Entry<Integer, Integer> entry : entryList ) {
        int key = entry.getKey();
        int vv  = entry.getValue();

        answer++;
        k = k - vv;

        if( k <= 0 ) {
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int k = 6;
    int[] tangerine = { 1, 3, 2, 5, 4, 5, 2, 3 };

    int result = solution.solution( k, tangerine );
    System.out.println( "RESULT = " + result );
  }
}
