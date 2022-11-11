package javaStudy.thread.PriorityExample;

//우선순위를 설정해서 스레드 실행
public class PriorityExample {
  public static void main(String[] args) {

    for( int i = 1; i <= 10; i++ ) {
      Thread thread = new CalcThread( "thread" + i );
      if( i != 10 ) {
        thread.setPriority( Thread.MIN_PRIORITY );
      } else {
        thread.setPriority( Thread.MAX_PRIORITY );
      }
      thread.start();
    }
  }
}
