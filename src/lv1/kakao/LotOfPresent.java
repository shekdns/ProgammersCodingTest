package lv1.kakao;

import java.util.*;

//가장 많이 받은 선물
public class LotOfPresent {
  public static class Solution {
    public int solution(String[] friends, String[] gifts) {
      int answer = 0;
      HashMap<String, HashMap<String, Integer>> toMap = new HashMap<>();
      HashMap<String, Integer> pMap = new HashMap<>();
      HashMap<String, Integer> sMap = new HashMap<>();

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
          sMap.put( to, sMap.getOrDefault( to, 0 ) + 1 );
        }
        toMap.put( name, innerMap );
      }

      ArrayList<Integer> list = new ArrayList<>();
      for( String name : friends ) {
        int toPresent = sMap.get( name ) == null ? 0 : sMap.get( name )/ friends.length;
        int frPresent = pMap.get( name ) == null ? 0 : pMap.get( name )/ friends.length;
        int diff = toPresent - frPresent;

        int total = 0;
        for( Map.Entry<String, HashMap<String,Integer>> entry : toMap.entrySet() ) {
          String eName = entry.getKey(); // ryan
          HashMap<String, Integer> eMap = entry.getValue();
          int eMapValue = eMap.get( name ) == null ? 0 : eMap.get( name ); // 3
          int tMapValue = toMap.get( name ).get( eName ) == null ? 0 : toMap.get( name ).get( eName );

          if( !eName.equals( name ) ) {
            if( tMapValue > eMapValue ) {
              total++;
            } else if( tMapValue == eMapValue ) {
              int eToPresent = sMap.get( eName ) == null ? 0 : sMap.get( eName ) / friends.length;
              int eFrPresent = pMap.get( eName ) == null ? 0 : pMap.get( eName ) / friends.length;
              int eDiff = eToPresent - eFrPresent;

              if( diff > eDiff ) {
                total++;
              }
            }
          }
        }
        list.add( total );
      }
      answer = Collections.max( list );
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
