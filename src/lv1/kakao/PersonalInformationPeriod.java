package lv1.kakao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

//2023 카카오 블라인드 채용 개인정보 수집 유효기간
public class PersonalInformationPeriod {

  private static class Solution {
    // 모두 -1일식 해야됨 그래서 1월 1일자의 경우 month도 - 해야됨  2021.01.01 -> 2021.12.28, 2021.12.28 -> 2022.11.27
    public static String returnAccesDay( String[] array, int access ) {
      int year  = Integer.parseInt( array[0] ); // 2021
      int month = Integer.parseInt( array[1] ); // 01
      int day   = ( Integer.parseInt( array[2] ) == 1 ) ? 28 : Integer.parseInt( array[2] ) - 1; // 28

      month = ( day == 28 ) ? month - 1 : month;

      int d = month + access;

      int mok = d / 12;
      int na  = d % 12;

      if( mok != 0 && na == 0 ) {
        mok = mok - 1;
        na  = 12;
      }

      String rY = String.valueOf( ( year + mok ) );
      String rM = ( na > 9 ) ? String.valueOf( na ) : "0" + na;
      String rD = ( day > 9 ) ? String.valueOf( day ) : "0" + day;

      return rY + "." + rM + "." + rD;
    }
    public static int[] solution( String today, String[] terms, String[] privacies ) {
      HashMap<String, Integer> map = new HashMap<>();

      for( int i = 0; i < terms.length; i++ ) {
        String[] split = terms[i].split( " " );
        map.put( split[0], Integer.parseInt( split[1] ) );
      }

      ArrayList<Integer> arrayList = new ArrayList<>();
      for( int i = 0; i < privacies.length; i++ ) {
        String[] split = privacies[i].split( " " );
        String[] array = split[0].split( "[.]" );
        int access = map.get( split[1] );
        String accessDay = "";
        if( access == 0 ) {
          accessDay = privacies[i];
        } else {
          accessDay = returnAccesDay( array, access );
        };
        System.out.println( "AA = " + accessDay );
//        if( Integer.parseInt( today.replace( ".", "" ) ) > Integer.parseInt( accessDay.replace( ".", "" ) ) ) {
//          arrayList.add( i + 1 );
//        }
      }

      int[] answer = arrayList.stream().mapToInt( Integer::intValue ).toArray();

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String today1 = "2022.05.19";
    String[] terms1 = { "A 6", "B 12", "C 3", "D 13" };
    String[] privacies1 = { "2020.01.01 B", "2022.01.02 B" };

    String today2 = "2020.01.01";
    String[] terms2 = {"Z 3", "D 5"};
    String[] privacies2 = { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };

    int[] result = solution.solution( today1, terms1, privacies1 );

//    for( int i : result ) {
//      System.out.print( i + " " );
//    }
  }
}
