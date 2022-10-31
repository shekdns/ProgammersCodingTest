package javaStudy.thread.threadName;

public class ThreadA extends Thread {

  public ThreadA() {
    setName( "ThreadA" );
  }

  @Override
  public void run() {
    System.out.println( getName() + " 이 출력한 내용 " );
  }
}
