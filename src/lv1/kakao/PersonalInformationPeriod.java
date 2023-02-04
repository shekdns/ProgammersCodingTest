package lv1.kakao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

//2023 카카오 블라인드 채용 개인정보 수집 유효기간
public class PersonalInformationPeriod {

  private static class Solution {
    // 모두 -1일식 해야됨 그래서 1월 1일자의 경우 month도 - 해야됨
    public static String returnAccesDay( String[] array, int access ) {
      int year  = Integer.parseInt( array[0] );
      int month = Integer.parseInt( array[1] );
      int day   = ( Integer.parseInt( array[2] ) ) == 1 ? 28 : Integer.parseInt( array[2] ) - 1;

      month = ( day == 28 ) ? month - 1 : month;
      year  = ( month == 1 && day == 1 ) ? year - 1 : year;

      int d = month + access;
      int mok = d / 12;
      int na  = d % 12;

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
        String accessDay = returnAccesDay( array, access );

        if( Integer.parseInt( today.replace( ".", "" ) ) > Integer.parseInt( accessDay.replace( ".", "" ) ) ) {
          arrayList.add( i + 1 );
        }
      }

      int[] answer = arrayList.stream().mapToInt( Integer::intValue ).toArray();

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String today1 = "2022.05.19";
    String[] terms1 = { "A 6", "B 12", "C 3" };
    String[] privacies1 = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

    String today2 = "2020.01.01";
    String[] terms2 = {"Z 3", "D 5"};
    String[] privacies2 = { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };

    int[] result = solution.solution( today2, terms2, privacies2 );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}