package lv1.kakao;

import java.util.HashMap;

//2023 카카오 블라인드 채용 개인정보 수집 유효기간
public class PersonalInformationPeriod {

  private static class Solution {
    public static int[] solution( String today, String[] terms, String[] privacies ) {
      int[] answer = {};

      HashMap<String, Integer> map = new HashMap<>();

      for( int i = 0; i < terms.length; i++ ) {
        String[] split = terms[i].split( " " );
        map.put( split[0], Integer.parseInt( split[1] ) );
      }

      //map.get( split[1] );
      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String today = "2022.05.19";
    String[] terms = { "A 6", "B 12", "C 3" };
    String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };

    int[] result = solution.solution( today, terms, privacies );

    for( int i : result ) {
      System.out.print( i + " " );
    }
  }
}
