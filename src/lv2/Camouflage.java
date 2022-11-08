package lv2;

import java.util.HashMap;
import java.util.Map;

//위장
public class Camouflage {
  public static class Solution {
    public int solution( String[][] clothes ) {
      int answer = 0;

      HashMap<String, Integer> map = new HashMap<>();

      for( int i = 0; i < clothes.length; i++ ) {
        map.put( clothes[i][1], map.getOrDefault( clothes[i][1], 0 ) + 1  );
      }

      int[] temp = new int[map.size()];

      int k = 0;
      int sum = 0;
      for( Map.Entry<String, Integer> entry : map.entrySet() ) {
        temp[k++] = entry.getValue();
        sum += entry.getValue();
      }

      if( temp.length > 1 ) {
        //옷의 종류는 temp.length;
        int t = 1;
        for( int i = 0; i < temp.length; i++ ) {
          int tt = ( 1 + temp[i] );
          t *= tt;
        }
        answer = t - 1;
      } else {
        answer = sum;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[][] clothes1 = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" }, { "green_turban", "headgear" } };
    String[][] clothes2 = { { "crow_mask", "face" }, { "blue_sunglasses", "face" }, { "smoky_makeup", "face" } };

    int result = solution.solution( clothes1 );

    System.out.println( "RESULT = " + result );
  }
}
