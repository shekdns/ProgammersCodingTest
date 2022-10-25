package lv2;

import java.util.ArrayList;

public class Capet {
  public static class Solution {
    public int[] solution ( int brown, int yellow ) {
      int[] answer = new int[2];
      ArrayList<Integer> arrayList = new ArrayList<>();
      int temp = brown + yellow;

      for( int i = 1; i <= temp; i++ ) {
        if( temp % i == 0 ) {
          arrayList.add( i );
        }
      }

      if( arrayList.size() % 2 == 0 ) {
        for( int i = 0; i < arrayList.size(); i++ ) {
          if( (arrayList.get(i) * arrayList.get( arrayList.size() - 1 - i )) == temp ) {
            if( ( arrayList.get( arrayList.size() - 1 - i ) - 2 ) * ( arrayList.get( i ) - 2 ) == yellow  ) {
              answer[0] = arrayList.get( arrayList.size() - 1 - i );
              answer[1] = arrayList.get(i);
              break;
            }
          }
        }
      } else {
        int l = arrayList.size() / 2;
        answer[0] = arrayList.get(l);
        answer[1] = arrayList.get(l);
//        for( int i = 0; i < arrayList.size(); i++ ) {
//          if( yellow + 2 == arrayList.get(i)  ) {
//            answer[0] = arrayList.get(i);
//            answer[1] = arrayList.get(i);
//            break;
//          }
//        }
      }

//      for( int i = 0; i < arrayList.size(); i++ ) {
        //System.out.println( "앞 = " + arrayList.get(i) );
        //System.out.println( "뒤 = " + arrayList.get( arrayList.size() - 1 - i ));
//        if( (arrayList.get(i) * arrayList.get( arrayList.size() - 1 - i )) == temp ) {
//          answer[0] = arrayList.get( arrayList.size() - 1 - i );
//          answer[1] = arrayList.get(i);
//          break;
//        }
//      }
      //12 -> 1 2 3 4 6 12
      //48 -> 1 2 3 4 6 8 12 16 24 48
      // 9 -> 1 3 9
      //24 -> 1 2 3 4 6 8 12 24
      //6  -> 1 2 3 6
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int brown  = 8;   // 24 24  -> 8 6    1 2 3 4 6 8 12 24
    int yellow = 1;   // -> 4 3   -> 1 2

    int[] result = solution.solution( brown, yellow );

    for( int r : result ) {
      System.out.print( r + " " );
    }
  }
}
