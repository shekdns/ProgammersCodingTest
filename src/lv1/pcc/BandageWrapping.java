package lv1.pcc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BandageWrapping {
  public static class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
      int[] time = new int[attacks.length];
      HashMap<Integer, Integer> map = new HashMap<>();
      for( int i = 0; i < attacks.length; i++ ) {
        time[i] = attacks[i][0];
        map.put( attacks[i][0], attacks[i][1] );
      }
      int max = Arrays.stream( time ).max().getAsInt();
      //Arrays.sort(attacks, Comparator.comparingInt((int[] o) -> o[0]));

      System.out.println( map );
      int useTime   = bandage[0];
      int heal      = bandage[1];
      int plusHeal  = bandage[2];
      int count = 0;
      int maxHealth = health;

      for( int i = 0; i <= max; i++ ) {
        if( i == 0 ) {
          continue;
        }
        if( map.get(i) != null ) {
          count = 0;
          health -= map.get(i);
        } else {
          count++;
          health += heal;
          if( count % useTime == 0 ) {
            health += plusHeal;
          }
          if( health > maxHealth ) {
            health = maxHealth;
          }
        }
        if( health < 1 ) {
          break;
        }
      }

      return ( health < 1 ) ? -1 : health;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] bandage   = { 5, 1, 5 }; //시전 시간, 회복량, 추가 회복량
    int health      = 30; // 최대 체력
    int[][] attacks = { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } }; // 공격시간, 데미지

    int result = solution.solution( bandage, health, attacks );

    System.out.println( "RESULT = " + result );
  }
}
