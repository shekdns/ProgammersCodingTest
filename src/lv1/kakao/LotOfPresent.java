package lv1.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//가장 많이 받은 선물
public class LotOfPresent {
  public static class Solution {
    public int solution(String[] friends, String[] gifts) {
      int answer = 0;
      HashMap<String, HashMap<String, Integer>> toMap = new HashMap<>();
      HashMap<String, Integer> pMap = new HashMap<>();

      for( String name : friends ) {
        HashMap<String, Integer> innerMap = new HashMap<>();
        for( String gift : gifts ) {
          String[] split = gift.split( " " );
          String to   = split[0];
          String from = split[1];
          if( to.equals( name ) ) {
            innerMap.put( from, innerMap.getOrDefault( from, 0 ) + 1 );
          }
          pMap.put( from, pMap.getOrDefault( from, 0 ) + 1 );
        }
        toMap.put( name, innerMap );
      }
      System.out.println( pMap );
      System.out.println( toMap );

      for( Map.Entry<String, HashMap<String,Integer>> entry : toMap.entrySet() ) {
        String mainKey = entry.getKey();
        HashMap<String, Integer> mainValue = entry.getValue();
        int jisu = pMap.get( mainKey ) == null ? 0 : pMap.get( mainKey ) / friends.length;

        for( Map.Entry<String, Integer> e : mainValue.entrySet() ) {
          String k = e.getKey();
          int    v = e.getValue();
          for (Map.Entry<String, HashMap<String, Integer>> entry2 : toMap.entrySet()) {
            String mainKey2 = entry2.getKey();
            HashMap<String, Integer> mainValue2 = entry2.getValue();
            int jisu2 = pMap.get(mainKey2) == null ? 0 : pMap.get(mainKey2) / friends.length;
            if ( mainKey.equals( mainKey2 ) ) {
              continue;
            }

          }
        }

      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] friends = { "muzi", "ryan", "frodo", "neo" };
    String[] gifts   = { "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" };

    int result = solution.solution( friends, gifts );
    System.out.println( "RESULT = " + result );
  }
}
