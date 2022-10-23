package lv2;

import java.util.ArrayList;

public class Capet {
  public static class Solution {
    public int[] solution ( int brown, int yellow ) {
      int[] answer = new int[2];
      ArrayList<Integer> arrayList = new ArrayList<>();
      int temp = brown + yellow;

      for( int i = 1; i <= temp; i++ ) {
        if( temp % i == 0 ) {
          arrayList.add( i );
        }
      }
      //12 -> 1 2 3 4 6 12
      //48 -> 1 2 3 4 6 8 12 16 24 48
      // 9 -> 1 3 9
      //24 -> 1 2 3 4 6 8 12 24

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int brown  = 18;   // 24 24  -> 8 6    1 2 3 4 6 8 12 24
    int yellow = 6;   // -> 4 3   -> 1 2

    int[] result = solution.solution( brown, yellow );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
