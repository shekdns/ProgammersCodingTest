package lv2;

import java.util.HashSet;

//Sumer Winder Coing 방문길이
public class LengthOfVist {
  public static class Solution {
    public int solution( String dirs ) {
      HashSet<String> hashSet = new HashSet<>();
      /*
         1. 스타팅 은 (0,0) 에서 시작
         2. 중복되는 길은 X
         3. 최대 5이상 넘어갈 경우 해당 값은 제외
         U: 위쪽으로 한 칸 가기
         D: 아래쪽으로 한 칸 가기
         R: 오른쪽으로 한 칸 가기
         L: 왼쪽으로 한 칸 가기
         x 가 5 또는 -5
       */
      int[][] array = { { 0, 0 } };

      for( int i = 0; i < dirs.length(); i++ ) {
        Character ch = dirs.charAt( i );
        int x = array[0][0];
        int y = array[0][1];
        String temp = x + "," + y;

        if( ch.equals( 'U' ) ) {
          y += 1;
          if( y > 5 ) {
            continue;
          }
          array[0][1] = y;
        } else if( ch.equals( 'D' ) ) {
          y -= 1;
          if( y < -5 ) {
            continue;
          }
          array[0][1] = y;
        } else if( ch.equals( 'R' ) ) {
          x += 1;
          if( x > 5 ) {
            continue;
          }
          array[0][0] = x;
        } else {
          x -= 1;
          if( x < -5 ) {
            continue;
          }
          array[0][0] = x;
        }
        System.out.println( temp + "->" + x + "," + y );
        hashSet.add( temp + "->" + x + "," + y );
      }

      //System.out.println( hashSet );

      return hashSet.size();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String dirs1 = "ULURRDLLU";
    String dirs2 = "LULLLLLLU";

    int reuslt = solution.solution( dirs1 );
    System.out.println( "REUSLT = " + reuslt );
  }
}
