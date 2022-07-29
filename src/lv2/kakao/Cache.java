package lv2.kakao;

import java.util.Deque;
import java.util.LinkedList;
//카카오 캐시
//디큐 에 대해 이해 및 lru 알고리즘 이해
public class Cache {
  public static class Soltuion {
    public static int CACHE_MISS = 5;
    public static int CACHE_HIT  = 1;

    public int solution( int cacheSize, String[] cities ) {
      int answer = 0;

      if( cacheSize == 0 ) {
        answer = CACHE_MISS * cities.length;
      } else {
        Deque<String> queue = new LinkedList<>();

        for( int i = 0; i < cities.length; i++ ) {
          String city = cities[i].toLowerCase();

          if( queue.remove( city ) == true ) {
            queue.addFirst( city );
            answer += CACHE_HIT;
          } else {
            int size = queue.size();
            if( size == cacheSize ) {
              queue.removeLast();
            }
            queue.addFirst( city );
            answer += CACHE_MISS;
          }
        }
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    Soltuion soltuion = new Soltuion();
    int cacheSize    = 2;
    String[] cities  = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
    String[] cities1 = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
    String[] cities2 = { "Jeju", "Pangyo", "NewYork", "newyork" };

    int result = soltuion.solution( cacheSize, cities2 );

    System.out.println( result );
  }
}
