package lv2.kakao;

import java.util.LinkedList;

//2018 kakao 블라인드 3차 n진수 게임
public class NGAME {

  public static class Solution {
    public String solution(int n, int t, int m, int p) {
      //String[] array = { "A", "B", "C", "D", "E", "F" };
      String answer = ""; //Integer.toString( i, m );
//13579BDF01234567
      StringBuilder sb = new StringBuilder();
      for( int i = 0; i <= t * m; i ++ ) {
        String temp = Integer.toString( i, n );
        System.out.println( "i = " + i  + " temp = " + temp.toUpperCase() );
        sb.append( temp.toUpperCase() );
      }
      System.out.println( sb );
      StringBuilder sb2 = new StringBuilder();
      int count = 0;
      int i = 0;
      while( true ) {
        count++;
        Character ch = String.valueOf( sb ).charAt( i );
        i++;
        if( count == p ) {
          sb2.append( ch );
        }
        if( sb2.length() == t ) {
          break;
        }
        if( count == m ) {
          count = 0;
        }
      }
//      for( int i = 0; i < String.valueOf( sb ).length(); i++ ) {
//        count++;
//        Character ch = String.valueOf( sb ).charAt( i );
//        if( count == p ) {
//          sb2.append( ch );
//        }
//        if( sb2.length() == t ) {
//          break;
//        }
//        if( count == m ) {
//          count = 0;
//        }
//      }
      System.out.println( sb2 );
      return sb2.toString();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 2; //진수
    int t = 4; //구해야할 값
    int m = 2; //인원
    int p = 1; //순번
    //0111
    String result = solution.solution( n, t, m, p );
    System.out.println( "RESULT = " + result );
  }
}
