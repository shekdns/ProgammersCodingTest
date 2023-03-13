package lv2;

import java.util.ArrayList;

public class N2Array {
  public static class Solution {
    public int[] solution( int n, long left, long right ) {
      int[] answer = new int[ (int)right - (int)left + 1 ];

      ArrayList<Integer> arrayList = new ArrayList<>();

      for( int i = 0; i < n; i++ ) {
        int num = i + 1;
        for( int j = 0; j < n; j++ ) {
          if( i == 0 ) {
            num = j + 1;
          } else if( i == ( n - 1 ) ) {
            num = n;
          } else {
            if( j > i ) {
              num++;
            }
          }
          arrayList.add( num );
        }
      }

      int j = 0;
      for( int i = (int)left; i <= (int)right; i++ ) {
        answer[j++] = arrayList.get(i);
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 4;
    long left = 7;
    long right = 14;

    int[] result = solution.solution( n, left, right );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
