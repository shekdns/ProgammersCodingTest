package lv2.kakao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

//2018 KAKAO BLIND RECRUITMENT 압축
public class ZipFile {
  public static class Solution {
    public int[] solution( String msg ) {
      int[] answer;
      ArrayList<Integer> list = new ArrayList<>();
      int index = 1;
      LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

      //1. 사전 초기화 작업
      for( Character c = 'A'; c <= 'Z'; c++ ) {
        map.put( String.valueOf( c ), index );
        index++;
      }
      System.out.println( map );
      boolean flag = false;
      while( true ) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        for( int j = 0; j < msg.length(); j++ ) {
          sb = sb.append( msg.charAt(j) );
          if( map.containsKey( sb.toString() ) == true ) {
            temp = map.get( sb.toString() );
            if( j + 1 == msg.length() ) {
              System.out.println( "J = " + j );
              list.add( temp );
              flag = true;
              break;
            } else {
              continue;
            }
          } else {
            map.put( sb.toString(), index );
            index++;
            System.out.println( "for 안에  = " + sb );
            msg = msg.substring( 0, 0 ) + "" + msg.substring( j );
            list.add( temp );
            break;
          }
        }
        System.out.println( "TEMP = " + temp );
        System.out.println( "SB = " + sb );
        System.out.println( "MSG = " + msg );
//        if( msg.equals( "" ) ) {
//          break;
//        }
        if( flag == true ) {
          break;
        }
      }

      answer = new int[list.size()];
      int i = 0;
      for( int v : list ) {
        answer[i++] = v;
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String msg1 = "KAKAO";
    String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
    String msg3 = "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISN" +
                  "OTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATI" +
            "SISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHAT" +
            "ISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHAT" +
            "THATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTH" +
            "ATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHAT" +
            "ISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHAT" +
            "THATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHA" +
            "TTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATT" +
            "HATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS";

    int[] result = solution.solution( msg3 );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
