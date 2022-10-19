package lv2;

public class BinaryTrans {
  public static class Solution {
    public int[] solution( String s ) {
      int[] answer = new int[2];

      String zeroCount  = "";
      int count = 0;
      String temp = "";
      int transCount = 0;

//      zeroCount += String.valueOf( s.length() - s.replace( "0", "" ).length() );
//      s = s.replace( "0", "" );
//      System.out.println( "1 = " + s );
//      temp = Integer.toBinaryString( Integer.parseInt( zeroCount ) );
//      System.out.println( "2 = " + temp );

      while( true ) {
        if( s.equals( "1" ) ) {
          answer[0] = transCount;
          answer[1] = count;
          break;
        }
        int i = s.replace("0", "").length();
        zeroCount = String.valueOf( i );
        System.out.println( "ZERO = " + zeroCount );
        count += s.length() - s.replace("0", "").length();
        s = s.replace( "0", "" );
        System.out.println( "replace = " + s );
        s = Integer.toBinaryString( Integer.parseInt( zeroCount ) );
        System.out.println( "binaryAfter = " + s );

        transCount++;
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = "110010101001";
    String ss = "01110";
    String sss = "1111111";

    int[] result = solution.solution( sss );

    for( int n : result ) {
      System.out.print( n + " " );
    }
  }
}
