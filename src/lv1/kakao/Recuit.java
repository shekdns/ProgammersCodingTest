package lv1.kakao;

import java.util.*;

public class Recuit {
  public static class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
      int[] answer;
      int[] temp;
      answer = new int[id_list.length];

      LinkedHashSet<String> rp = new LinkedHashSet<String>();
      for( int i = 0; i < report.length; i++ ) {
        rp.add( report[i] );
      }

      LinkedHashMap<String, LinkedList<String>>  map = new LinkedHashMap<>();

      for( String id : id_list ) {
        map.put( id, new LinkedList<String>() );
      }

      Iterator iter = rp.iterator();
      while( iter.hasNext() ) {
        String[] arr = iter.next().toString().split( " ", -1 );
        String key   = arr[0];
        String value = arr[1];

        map.get( value ).add( key );
      }

      LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
      for( String kkey : map.keySet() ) {
        if( map.get( kkey ).size() >= k ) {
          for( String vvalue : map.get( kkey ) ) {
            lhm.put( vvalue, lhm.getOrDefault( vvalue, 0 ) + 1 );
          }
        }
      }

      for( int i = 0; i < id_list.length; i++ ) {
        answer[i] = lhm.getOrDefault( id_list[i], 0 );
      }

      return answer;
    }
  }
  public static void main(String[] args) {

  }
}