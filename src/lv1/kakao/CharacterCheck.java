package lv1.kakao;


import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterCheck {
  public static class Solution {
    public String solution( String[] array, int[] choices ) {
      String answer = "";

      LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
      String[] cType  = { "R", "T", "C", "F", "J", "M", "A", "N" };
      int[] cPoint    =  { 3, 2, 1, 0, 1, 2, 3 }; // 1 2 3 4 5 6 7
      String[] split;
      StringBuilder sb = new StringBuilder();

      for( String s : cType ) {
        hashMap.put( s, 0 );
      }

      for( int i = 0; i < array.length; i++ ) {
        String temp = array[i];
        split = new String[2];
        for( int j = 0; j < temp.length(); j++ ) {
          Character ch = temp.charAt(j);
          split[j] = String.valueOf(ch);
        }

        int p = cPoint[choices[i]-1];
        String ss = "";
        if( choices[i] > 4 ) {
          ss = split[1];
        } else {
          ss = split[0];
        }
        System.out.println( "P = " + p + "  CHOICE = " + choices[i] + "  SS = " + ss );
        hashMap.put( ss, hashMap.getOrDefault( ss, 0 ) + p );
      }
      System.out.println( hashMap );

      for( int i = 0; i < cType.length; i++ ) {
        if( i % 2 != 0 ) {
          if( hashMap.get(cType[i-1]) < hashMap.get(cType[i]) ) {  // 0 3
            sb.append( cType[i] );
          } else  { // 1 0 || 0 0
            sb.append( cType[i-1] );
          }
        }
      }

      answer = sb.toString();

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] array = { "AN", "CF", "MJ", "RT", "NA" };
    int[] choices  = { 5, 3, 2, 7, 5 };

    String result = solution.solution( array, choices );
    System.out.println( "RESULT = " + result );
  }
}
