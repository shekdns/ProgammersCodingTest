package lv2.kakao;

public class NewsClustering {
  public boolean checkStr( Character ch ) {
    boolean flag = true;

    return flag;
  }

  public static class Solution {
    public int solution( String str1, String str2 ) {
      int answer = 0;

      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();

      str1 = str1.replaceAll("[0-9]+", "?" );
      str1 = str1.replaceAll( "[ !@#$%^&*(),+_,-.?\\\":{}|<>]", "?" );
      str2 = str2.replaceAll("[0-9]+", "?" );
      str2 = str2.replaceAll( "[ !@#$%^&*(),+_,-.?\\\":{}|<>]", "?" );
      System.out.println( str1 );

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String str1 = "FRANCE";
    String str2 = "french";
    String str3 = "aa1+_-aa2";
    int result = solution.solution( str3, str2 ); //16384

    System.out.println( "RESULT = " + result );

  }
}
