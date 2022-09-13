package lv2.kakao;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;

public class FileSort {
  public static class Solution {
    public String[] solution( String[] files ) {
      String[] answer = {};
      String[] header = {};
      String[] number = {};

      LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
      LinkedList<String> headerList = new LinkedList<>();
      LinkedList<String> numberList = new LinkedList<>();
      LinkedList<String> tempList   = new LinkedList<>();

      for( int i = 0; i < files.length; i++ ) {
        map.put( i + 1, files[i] );
      }

      System.out.println( "MAP = " + map );

      //1. 헤더 검사 2. 숫자 검사
      for( int i = 0; i < files.length; i++ ) {
        String temp = files[i].toLowerCase();

        Integer numberInteger = 0;

        header = temp.split( "\\d+" );  // 문자만 추출
        number = temp.split( "\\D+" );  // 숫자만 추출

        //if( !number[1].equals( "" ) ) {
        // numberInteger = Integer.parseInt( String.valueOf( number[1] ) );
        //}
        //String[] header = files[i].split( "\\.|-|' '" );
        System.out.println( "Header = " + header[0] + " Number = " + number[1] );

        tempList.add( header[0] + number[1] );

        if( i == files.length - 1 ) {
          Collections.sort( tempList );
        }
      }

      System.out.println( "TEMP LSIT = " + tempList );

      //5 50 10 14 ->  10 50 5 14
//      for( int i = 1; i < files.length; i++ ) {
//        if( headerList.get(i).equals( headerList.get(i-1) ) ) {
//
//        }
//      }

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

    String[] result = solution.solution( files1 );

    for( String s : result ) {
      System.out.println( s + " " );
    }
  }
}
