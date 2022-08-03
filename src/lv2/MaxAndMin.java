package lv2;

import java.util.ArrayList;
import java.util.Collections;

public class MaxAndMin {
  public static class Solution {
    public String solution( String s ) {
      String answer = "";

      String[] split = s.split( " " );

      ArrayList<Integer> arrayList = new ArrayList<>();

      for( String ss : split ) {
        arrayList.add( Integer.parseInt( ss ) );
      }

      int max = Collections.max( arrayList );
      int min = Collections.min( arrayList );

      answer = min + " " + max;
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "1 2 3 4";
    String s2 = "-1 -2 -3 -4";
    String s3 = "-1 -1";

    String result = solution.solution( s2 );

    System.out.println( result );
  }
}
