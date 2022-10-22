package lv2.kakao;

import java.util.ArrayList;
import java.util.HashSet;

public class NewsClustering {
  public static class Solution {
    public int solution( String str1, String str2 ) {
      int answer = 0;

      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();

      str1 = str1.replaceAll("[0-9]+", "?" );
      str1 = str1.replaceAll( "[ !@#$%^&*(),+_,-=.?\\\":{}|<>]", "?" );
      str2 = str2.replaceAll("[0-9]+", "?" );
      str2 = str2.replaceAll( "[ !@#$%^&*(),+_,-=.?\\\":{}|<>]", "?" );

      System.out.println( "STR1 = " + str1 );
      System.out.println( "STR2 = " + str2 );

      //{FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}
      //교집합 : {FR, NC}
      //합집합 : {FR, RA, AN, NC, CE, RE, EN, CH}
      ArrayList<String> str1Temp = new ArrayList<>();
      ArrayList<String> str2Temp = new ArrayList<>();
      ArrayList<String> inter    = new ArrayList<>();
      ArrayList<String> union    = new ArrayList<>();
      //HashSet<String> set = new HashSet<>();

      for( int i = 0; i < str1.length() - 1; i++ ) {
        Character ch1 = str1.charAt(i);
        Character ch2 = str1.charAt(i + 1);

        if( !String.valueOf( ch1 ).equals( "?" ) && !String.valueOf( ch2 ).equals( "?" ) ) {
          str1Temp.add( String.valueOf( ch1 ) + String.valueOf( ch2 ) );
        }
      }

      for( int i = 0; i < str2.length() - 1; i++ ) {
        Character ch1 = str2.charAt(i);
        Character ch2 = str2.charAt(i + 1);

        System.out.println( "CH1 = " + ch1 + "  CH2 = " + ch2 );
        if( !String.valueOf( ch1 ).equals( "?" ) && !String.valueOf( ch2 ).equals( "?" ) ) {
          str2Temp.add( String.valueOf( ch1 ) + String.valueOf( ch2 ) );
        }
      }

      System.out.println( "STR1TEMP = " + str1Temp );
      System.out.println( "STR2TEMP = " + str2Temp );

      for( String s : str1Temp ) {
        if( str2Temp.remove( s ) == true ) {
          inter.add( s );
        }
        union.add( s );
      }
      for( String s : str2Temp ) {
        union.add( s );
      }

      double d = 0.0;

      System.out.println( (double)inter.size() + " " + (double)union.size() );

      if( union.size() == 0 ) {
        d = 1;
      } else {
        d = (double)inter.size() / (double)union.size();
      }

      answer = (int) (d * 65536);

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String str1 = "FRANCE";
    String str2 = "french";

    String str3 = "handshake";
    String str4 = "shake hands";

    String str5 = "aa1+aa2";
    String str6 = "AAAA12";

    String str7 = " abc=";
    String str8 = "abbb";

    int result = solution.solution( str7, str8 ); //16384     43690

    System.out.println( "RESULT = " + result );

  }
}
