package lv1.kakao;

import java.util.LinkedList;

public class Dart {
  public static class Solution {
    public int solution( String dartResult ) {
      int answer = 0;

      dartResult = dartResult.replaceAll( "10", "?" );

      String[] array = new String[dartResult.length()];
      for( int i = 0; i < dartResult.length(); i++ ) {
        Character ch = dartResult.charAt( i );
        array[i] = String.valueOf( ch );
      }

      LinkedList<Double> list = new LinkedList<>();
      int count = 0;
      for( int i = 0; i < array.length; i++ ) {
        double temp = 0;
        System.out.print( array[i] + " " );
        if( array[i].equals( "S" ) || array[i].equals( "D" ) || array[i].equals( "T" ) ) {
          if( array[i].equals( "S" ) ) {
            temp = Integer.parseInt( array[i - 1] );
            list.add( temp );
            count++;
          } else if( array[i].equals( "D" ) ) {
            temp = Math.pow( Integer.parseInt( array[i -1]), 2 );
            list.add( temp );
            count++;
          } else if( array[i].equals( "T" ) ) {
            temp = Math.pow( Integer.parseInt( array[i - 1]), 3);
            list.add( temp );
            count++;
          }
        } else if( array[i].equals( "?" ) ) {
          array[i] = "10";
        } else if( array[i].equals( "#" ) || array[i].equals( "*" ) ) {
          if( array[i].equals( "*" ) ) {
            if( count == 1 ) {
              list.set( count - 1, list.get( count - 1 ) * 2 );
            } else if( count == 2 ) {
              list.set( count - 2, list.get( count - 2 ) * 2 );
              list.set( count - 1, list.get( count - 1 ) * 2 );
            } else {
              list.set( count - 2, list.get( count - 2 ) * 2 );
              list.set( count - 1, list.get( count - 1 ) * 2 );
            }
          } else  {
            list.set( count - 1, list.get( count - 1 ) * -1 );
          }
        }
      }
      double sum = 0;
      for( int i = 0; i < list.size(); i++ ) {
        sum += list.get( i );
      }

      answer = ( int )sum;
      return answer;
    }
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    //String dartResult = "1S2D*3T";
    //String dartResult = "1D2S#10S";
    //String dartResult = "1S*2T3S";
    String dartResult = "1S*2T*3S";

    int result = solution.solution( dartResult );
    System.out.println( "ANSWER = " + result );
  }
}