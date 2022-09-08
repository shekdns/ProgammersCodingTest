package lv2.kakao;

public class FileSort {
  public static class Solution {
    public String[] solution( String[] files ) {
      String[] answer = {};

      //1. 헤더 검사 2. 숫자 검사
      for( int i = 0; i < files.length; i++ ) {
        String[] header = files[i].split( " " );
        //String[] header = files[i].split( "\\.|-|' '" );
        System.out.println( header[0] );
      }

      return answer;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] files1 = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
    String[] files2 = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };
    String[] files3 = { "F5 Freedom", "B50 Superfortress" };

    String testText1 = "foo9.txt";
    String testText2 = "foo010bar020.zip";
    String testText3 = "F-15";

    String[] result = solution.solution( files2 );

    for( String s : result ) {
      System.out.println( s + " " );
    }
  }
}
