package javaStudy.thread;

import javax.swing.*;
import java.awt.*;

public class BeepPrintExample2 {
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 0; i < 5; i++ ) {
          toolkit.beep();
          try {
            Thread.sleep( 500 );
          } catch ( Exception e ) {
            e.printStackTrace();
          }
        }
      }
    });

    thread.start();

    //이것도 됨됨
//   new Thread(new Runnable() {
//      @Override
//      public void run() {
//
//      }
//    }).start();

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
