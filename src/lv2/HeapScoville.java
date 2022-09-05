package lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HeapScoville {
  public static class Solution {
    public int solution( int[] scoville, int k ) {
      int answer = 0;
      ArrayList<Integer> arrayList = new ArrayList<>();
      for( int v : scoville ) {
        arrayList.add( v );
      }

      System.out.println( "ARRAYLIST = " + arrayList );
      for( int i = 1; i < arrayList.size(); i++ ) {
        int c = 1;
        boolean flag = true;
        Collections.sort( arrayList );
        if( i == 1 && arrayList.get(i-0) >= k ) {
          break;
        }
        int temp = arrayList.get(c-1) + (arrayList.get(c) * 2);
        System.out.println( temp );
        arrayList.remove(c-1);
        arrayList.set(c-1, temp);
        System.out.println( "ARRAYLIST = " + arrayList );
        answer++;
        for( int j = 0; j < arrayList.size(); j++ ) {
          if( arrayList.get(j) < k ) {
            flag = false;
          }
        }
        if( flag == true ) {
          break;
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] scoville = { 1, 2, 3, 9, 10, 12 };
    int[] scoville2 = { 9, 10, 12 };
    int k = 7;

    int result = solution.solution( scoville, k );
    System.out.println( "RESULT = " + result );
  }


}
