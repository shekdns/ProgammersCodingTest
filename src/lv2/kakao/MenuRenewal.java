package lv2.kakao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Stack;

//2021 KAKAO BLIND RECRUITMENT
//메뉴 리뉴얼
public class MenuRenewal {
  //public static HashMap<String, Integer> staticMap = new HashMap<>();

  public static class Solution {
    public String[] solution( String[] orders, int[] course ) {
      String[] answer = {};

      String[] temp;
      temp = new String[orders.length];
      Stack<String> stack = new Stack<>();

      for( String order : orders ) {
        char[] ch = order.toCharArray();
        for( char c : ch ) {

        }
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] orders = {  "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
    int[] course = { 2, 3, 4 };

    String[] result = solution.solution( orders, course );

    for( String s : result ) {
      System.out.print( s + " " );
    }
  }
}
