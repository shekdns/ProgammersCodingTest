package lv2.kakao;

import java.util.*;

//2021 KAKAO BLIND RECRUITMENT
//메뉴 리뉴얼
public class MenuRenewal {
  public static List<HashMap<String, Integer>> staticMap = new ArrayList<>();
  public static int[] maxCnt = new int[11];

  public static void makeMenu( char[] array, int pos, StringBuilder sb ) {
    if( pos >= array.length ) {
      int len = sb.length();
      if( len >= 2 ) {
        int cnt = staticMap.get( len ).getOrDefault( sb.toString(), 0 ) + 1;
        staticMap.get( len ).put( sb.toString(), cnt );
        maxCnt[len] = Math.max( maxCnt[len], cnt );
      }
      return;
    }

    makeMenu( array, pos + 1, sb.append( array[pos] ) );
    sb.setLength( sb.length() - 1 );
    makeMenu( array, pos + 1, sb );
  }

  public static class Solution {
    public String[] solution( String[] orders, int[] course ) {
      String[] answer = {};

      for( int i = 0; i < 11; i++ ) {
        staticMap.add( new HashMap<>() );
      }

      for( String order : orders ) {
        char[] ch = order.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        makeMenu( ch, 0, sb );
      }

      List<String> list = new ArrayList<>();
      for( int len : course ) {
        for( Map.Entry<String, Integer> entry : staticMap.get( len ).entrySet() ) {
          if( entry.getValue() >= 2 && entry.getValue() == maxCnt[len] ) {
            list.add( entry.getKey() );
          }
        }
      }

      Collections.sort( list );

      answer = list.toArray( new String[list.size()] );

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
