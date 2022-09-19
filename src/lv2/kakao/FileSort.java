package lv2.kakao;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class FileSort {
  public static class Solution {
    public String[] solution( String[] files ) {
      String[] answer = {};
      String[] header = {};
      String[] number = {};

      //1. 헤더 검사 2. 숫자 검사
      for( int i = 0; i < files.length; i++ ) {
        header = files[i].split( "\\d+" );  // 문자만 추출
        //number = files[i].split( "\\D+" );  // 숫자만 추출

        Character h = header[0].toLowerCase().charAt(0);
        for( int j = i + 1; j < files.length; j++ ) {
          String[] jHeader = files[j].split( "\\d+" );
          Character jh = jHeader[0].toLowerCase().charAt(0);
          if( h.compareTo( jh ) > 0 ) {
            String temp = files[i];
            files[i] = files[j];
            files[j] = temp;
          }
        }
      }

      for( int i = 0; i < files.length; i++ ) {
        header = files[i].split( "\\d+" );  // 문자만 추출
        Character h = header[0].toLowerCase().charAt(0);
        for( int k = i + 1; k < files.length; k++ ) {
          number = files[i].split( "\\D+" );  // 숫자만 추출
          String[] jHeader = files[k].split( "\\d+" );
          String[] kNumber = files[k].split( "\\D+" );
          Character jh = jHeader[0].toLowerCase().charAt(0);
          if( h.compareTo( jh ) == 0 ) {
            if( Integer.parseInt( String.valueOf( number[1] ) ) > Integer.parseInt( String.valueOf( kNumber[1]) ) ) {
              String temp = files[i];
              files[i] = files[k];
              files[k] = temp;
            }
          }
        }
      }

      answer = files;

      return answer;
    }
  }

  /*
     1. header 순
     2. if( header[i].equals( header[i+1] ) {
          if( Integer.parseInt( number[i] ) != Integer.parseInt( number[i+1] ) {

          }
        }
   */

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] files1 = { "img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG" };
                     // "img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"
    String[] files2 = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat" };
                     // "A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"
    String[] files3 = { "F5 Freedom", "B50 Superfortress" };

    String testText1 = "foo9.txt";  //Header foo Number 9 Tail .txt
    String testText2 = "foo010bar020.zip"; // Header foo Number 010 Tail zip
    String testText3 = "F-15";  // Header F- Number 15

    String[] files4 = { testText1, testText2, testText3 };

    /*
        1. 문자열 a~z 기준?

     */

    String[] result = solution.solution( files4 );

    for( String s : result ) {
      System.out.print( s + " " );
    }
  }
}
