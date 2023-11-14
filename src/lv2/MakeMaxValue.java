package lv2;
//큰 수 만들기
public class MakeMaxValue {
  public static class Solution {
    public String solution( String number, int k ) {
      String answer = "";

      String front = number.substring( 0, number.length() - k  );
      String back  = number.substring( number.length() - k  );
      System.out.println( "F = " + front );
      int postion = 0;
      int leng = front.length() - k;
      System.out.println( leng );
      Character ch = front.charAt( 0 );
      int max = Integer.parseInt( ch.toString() );

      if( front.length() + 1 <= k ) {

      }
//      for( int i = 1; i < front.length(); i++ ) {
//        postion = i;
//        ch = front.charAt( i );
//        int t = Integer.parseInt( ch.toString( ) );
//        if(  )
//
//      }
      //417725
      String d = "417725";
      System.out.println( d.substring( d.length() - ( d.length() - 5 ) ) );

      return answer;
    }
  }
  public static void main(String[] args) {
    Solution solution = new Solution();
    String number1 = "1924";
    String number2 = "1231234";
    String number3 = "4177252841";

    int k1 = 2;
    int k2 = 3;
    int k3 = 4;

    System.out.println( "RESULT = " + solution.solution( number3, k3 ) );
  }
}
