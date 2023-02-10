package lv2.kakao;

import java.util.LinkedList;

//2018 kakao 블라인드 3차 n진수 게임
public class NGAME {

  public static class Solution {
    public String solution(int n, int t, int m, int p) {
      String answer = ""; //Integer.toString( i, m );

      StringBuilder sb = new StringBuilder();
      for( int i = 0; i <= t * 2; i ++ ) {
        String temp = Integer.toString( i, n );
        sb.append( temp.toUpperCase() );
      }
      System.out.println( sb );
      LinkedList<String> list = new LinkedList<>();
      int count = 0;
      for( int i = 0; i < String.valueOf( sb ).length(); i++ ) {
        count++;
        Character ch = String.valueOf( sb ).charAt( i );
        list.add( count + ":" + ch );
        if( count == m ) {
          count = 0;
        }
      }
      System.out.println( list );
      StringBuilder tt = new StringBuilder();
      for( String s : list ) {
        String[] split = s.split( ":" );
        if( split[0].equals( String.valueOf( p ) ) ) {
          tt.append( split[1] );
        }
      }

      System.out.println( tt.substring( 0 , t ) );
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n = 16; //진수
    int t = 16; //구해야할 값
    int m = 2; //인원
    int p = 2; //순번
    //0111
    String result = solution.solution( n, t, m, p );
    System.out.println( "RESULT = " + result );
  }
}
