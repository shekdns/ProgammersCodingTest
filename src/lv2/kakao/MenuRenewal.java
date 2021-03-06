package lv2.kakao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class MenuRenewal {
  public static class Solution {
    public String[] solution( String[] orders, int[] course ) {
      String[] answer = {};

      String[] temp;
      temp = new String[orders.length];
      LinkedHashMap<Integer, LinkedList<String>> map = new LinkedHashMap<>();

      for( int i = 0; i < orders.length; i++ ) {
        LinkedList<String> list = new LinkedList<>();
        for( int j = 0; j < orders[i].length(); j++ ) {
          Character ch = orders[i].charAt( j );
          list.add( String.valueOf( ch ) );
        }
        map.put( i + 1, list );
      }

      System.out.println( map );

//      for( String menu : orders ) {
//        for( int num : course ) {
//          if( menu.length() == num ) {
//
//          }
//        }
//      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] orders = {  "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
    int[] course = { 2, 3, 4 };

    String[] result = solution.solution( orders, course );

    for( String s : result ) {
      System.out.print( s + " " );
    }
  }
}
