package lv2.kakao;

import java.util.*;

public class FileSort {
  static class File implements Comparable<File>  {
    int num;
    String header = "";
    String number = "";
    String file_name = "";

    File( String str ) {
      String[] hArray = str.split( "\\d+" );
      this.header = hArray[0];
      String[] nArray = str.split( "\\D+" );
      this.number = nArray[1];
      this.file_name = str;
    }

    @Override
    public int compareTo(File o) {
      String str1 = this.header.toLowerCase(); // 자기 자신
      String str2 = o.header.toLowerCase();    // 들어온 객체 비교

      if( str1.equals( str2 ) ) {
        int num1 = Integer.parseInt( this.number );
        int num2 = Integer.parseInt( o.number );

        if( num1 == num2 ) {
          return this.num - o.num;
        }
        return num1 - num2;
      }
      return str1.compareTo( str2 );
    }
  }
  public static class Solution {
    public String[] solution( String[] files ) {
      String[] answer = {};

      ArrayList<File> list = new ArrayList<>();

      for( int i = 0; i < files.length; i++ ) {
        list.add( new File( files[i] ) );
      }

      answer = new String[list.size()];

      Collections.sort( list );

      int i = 0;
      for( File file : list ) {
        answer[i++] = file.file_name;
      }

      //1. 헤더 검사 2. 숫자 검사
//      for( int i = 0; i < files.length; i++ ) {
//        header = files[i].split( "\\d+" );  // 문자만 추출
//        //number = files[i].split( "\\D+" );  // 숫자만 추출
//
//        Character h = header[0].toLowerCase().charAt(0);
//        for( int j = i + 1; j < files.length; j++ ) {
//          String[] jHeader = files[j].split( "\\d+" );
//          Character jh = jHeader[0].toLowerCase().charAt(0);
//          if( h.compareTo( jh ) > 0 ) {
//            String temp = files[i];
//            files[i] = files[j];
//            files[j] = temp;
//          }
//        }
//      }
//
//      for( int i = 0; i < files.length; i++ ) {
//        header = files[i].split( "\\d+" );  // 문자만 추출
//        Character h = header[0].toLowerCase().charAt(0);
//        for( int k = i + 1; k < files.length; k++ ) {
//          number = files[i].split( "\\D+" );  // 숫자만 추출
//
//          String[] jHeader = files[k].split( "\\d+" );
//          String[] kNumber = files[k].split( "\\D+" );
//          Character jh = jHeader[0].toLowerCase().charAt(0);
//          System.out.println( h + " " + jh );
//          if( h.compareTo( jh ) == 0 ) {
//            if( Integer.parseInt( String.valueOf( number[1] ) ) > Integer.parseInt( String.valueOf( kNumber[1]) ) ) {
//              String temp = files[i];
//              files[i] = files[k];
//              files[k] = temp;
//            }
//          }
//        }
//      }

//      answer = files;

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

    String a = "img100.p2ng";
    String b = "aa00001234563";
    String c = "aa0000123456";

    String[] files4 = { testText1, testText2, testText3 };

    /*
        1. 문자열 a~z 기준?

     */

    String[] result = solution.solution( files2 );

    for( String s : result ) {
      System.out.print( s + " " );
    }
  }
}
