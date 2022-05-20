package lv2.kakao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class OpenChat {
  public static class Solution {
    public String[] solution( String[] record ) {
      String[] answer;

      HashMap<String, String> map = new HashMap<>();
      int count = 0;
      for( int i = 0; i < record.length; i++ ) {
        String[] split = record[i].split( " ", -1 );
        String io = split[0];

        if( !io.equals( "Leave") ) {
          String id = split[1];
          String nn = split[2];
          if( io.equals( "Change") ) {
            count++;
          }
          map.put( id, nn );
        }
      }

      answer = new String[record.length - count];

      for( int i = 0; i < record.length; i++ ) {
        String[] split = record[i].split( " " );
        String io = split[0];
        String id = split[1];

        if( io.equals( "Enter") ) {
          answer[i] = map.get( id ) + "님이 들어왔습니다.";
        } else if( io.equals( "Leave") ) {
          answer[i] = map.get( id ) + "님이 나갔습니다.";
        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] record = { "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan" };

    String[] record2 = { "Enter uid1234 Muzi",
            "Enter uid4567 Prodo",
            "Change uid4567 Ryan",
            "Leave uid1234",
            "Enter uid1234 Prodo" };


    String[] result = {};
    result = solution.solution( record );

    for( String string : result ) {
      System.out.println( string );
    }
    //"Prodo님이 들어왔습니다.",
    // "Ryan님이 들어왔습니다.",
    // "Prodo님이 나갔습니다.",
    // "Prodo님이 들어왔습니다."

  }
}