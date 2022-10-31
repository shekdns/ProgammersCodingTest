package javaStudy.thread;

import java.awt.*;

public class BeepPrintExample1 {
  public static void main(String[] args) {
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    for( int i = 0; i < 5; i++ ) {
      toolkit.beep();
      try {
        Thread.sleep( 500);
      } catch ( Exception e ) {
        e.printStackTrace();
      }
    }

    for( int i = 0; i < 5; i++ ) {
      System.out.println( "COUNT" );
      try {
        Thread.sleep( 500 );
      } catch ( Exception e ) {
        e.printStackTrace();
      }
    }
  }
}
