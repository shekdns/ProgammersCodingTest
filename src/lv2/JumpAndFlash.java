package lv2;

public class JumpAndFlash {
  public static class Soltuion {
    public int solution( int n ) {
      int ans = 0;

      while( n != 0 ) {
        if( n % 2 != 0 ) {
          n -= 1;
          System.out.println( " 홀수 N = " + n );
          ans++;
        } else {
          System.out.println( " 짝수 N = " + n );
          n /= 2;
        }
      }
      return ans;
    }
  }

  public static void main(String[] args) {
    Soltuion soltuion = new Soltuion();
    int n = 5000;

    int result = soltuion.solution( n );
    System.out.println( "RESULT = " + result );

  }
}
